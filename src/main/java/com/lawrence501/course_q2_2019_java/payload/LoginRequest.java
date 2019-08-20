package com.lawrence501.course_q2_2019_java.payload;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
  @NotBlank(message = "Username cannot be blank")
  private String username;
  @NotBlank(message = "Password cannot be blank")
  private String password;

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}