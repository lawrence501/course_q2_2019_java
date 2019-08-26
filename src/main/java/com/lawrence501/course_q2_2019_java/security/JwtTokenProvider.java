package com.lawrence501.course_q2_2019_java.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.lawrence501.course_q2_2019_java.domain.User;
import static com.lawrence501.course_q2_2019_java.security.SecurityConstants.EXPIRATION_TIME;
import static com.lawrence501.course_q2_2019_java.security.SecurityConstants.SECRET;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {
  public String generateToken(Authentication auth) {
    User user = (User) auth.getPrincipal();
    Date now = new Date(System.currentTimeMillis());
    Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);
    String userId = Long.toString(user.getId());

    Map<String, Object> claims = new HashMap<>();
    claims.put("id", userId);
    claims.put("username", user.getUsername());
    claims.put("fullName", user.getFullName());

    return Jwts.builder().setSubject(userId).setClaims(claims).setIssuedAt(now).setExpiration(expiryDate)
        .signWith(SignatureAlgorithm.HS512, SECRET).compact();
  }
}