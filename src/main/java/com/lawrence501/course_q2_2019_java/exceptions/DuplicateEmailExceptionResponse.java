package com.lawrence501.course_q2_2019_java.exceptions;

public class DuplicateEmailExceptionResponse {
  private String username;

  public DuplicateEmailExceptionResponse(String username) {
    this.username = username;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

}