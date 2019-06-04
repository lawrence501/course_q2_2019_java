package com.lawrence501.course_q2_2019_java.exceptions;

public class ProjectIdExceptionResponse {
  private String projectIdentifier;

  public ProjectIdExceptionResponse(String projectIdentifier) {
    this.projectIdentifier = projectIdentifier;
  }

  public String getProjectIdentifier() {
    return this.projectIdentifier;
  }

  public void setProjectIdentifier(String projectIdentifier) {
    this.projectIdentifier = projectIdentifier;
  }

}