package com.lawrence501.course_q2_2019_java.payload;

public class JwtLoginSuccessResponse {
  private boolean success;
  private String token;

  public JwtLoginSuccessResponse(boolean success, String token) {
    this.success = success;
    this.token = token;
  }

  public boolean isSuccess() {
    return this.success;
  }

  public boolean getSuccess() {
    return this.success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public String getToken() {
    return this.token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  @Override
  public String toString() {
    return "{" + " success='" + isSuccess() + "'" + ", token='" + getToken() + "'" + "}";
  }

}