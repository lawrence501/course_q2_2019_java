package com.lawrence501.course_q2_2019_java.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.lawrence501.course_q2_2019_java.exceptions.InvalidLoginResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationEntrypoint implements AuthenticationEntryPoint {
  // Run whenever an AuthenticationException is thrown
  @Override
  public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
      AuthenticationException e) throws IOException, ServletException {
    InvalidLoginResponse loginResponse = new InvalidLoginResponse();
    String jsonLoginResponse = new Gson().toJson(loginResponse);

    httpServletResponse.setContentType("application/json");
    httpServletResponse.setStatus(401);
    httpServletResponse.getWriter().print(jsonLoginResponse);
  }
}