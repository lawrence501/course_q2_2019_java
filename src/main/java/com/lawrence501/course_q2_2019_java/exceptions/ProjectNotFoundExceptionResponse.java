package com.lawrence501.course_q2_2019_java.exceptions;

public class ProjectNotFoundExceptionResponse {
  private String projectNotFound;

  public ProjectNotFoundExceptionResponse(String projectNotFound) {
    this.projectNotFound = projectNotFound;
  }

  public String getProjectNotFound() {
    return this.projectNotFound;
  }

  public void setProjectNotFound(String projectNotFound) {
    this.projectNotFound = projectNotFound;
  }

}