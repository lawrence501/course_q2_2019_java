package com.lawrence501.course_q2_2019_java.security;

import java.util.Date;

import com.lawrence501.course_q2_2019_java.domain.User;
import static com.lawrence501.course_q2_2019_java.security.SecurityConstants.EXPIRATION_TIME;

import org.springframework.security.core.Authentication;

public class JwtTokenProvider {
  public String generateToken(Authentication auth) {
    User user = (User) auth.getPrincipal();
    Date now = new Date(System.currentTimeMillis());
    Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);
    
  }
}