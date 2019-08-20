package com.lawrence501.course_q2_2019_java.security;

public class SecurityConstants {
  public static final String REGISTER_URLS = "/api/users/**";
  public static final String H2_URL = "h2-console/**";
  public static final String SECRET = "SecretKey";
  public static final String TOKEN_PREFIX = "Bearer ";
  public static final String HEADER = "Authorization";
  public static final long EXPIRATION_TIME = 30_000;
}