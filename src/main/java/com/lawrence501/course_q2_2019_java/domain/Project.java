package com.lawrence501.course_q2_2019_java.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Project {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank(message = "Project name is required")
  private String projectName;
  @Column(updatable = false, unique = true)
  @NotBlank(message = "Project identifier is required")
  @Size(min = 4, max = 5, message = "Project identifier must be between 4 and 5 characters")
  private String projectIdentifier;
  @NotBlank(message = "Project description is required")
  private String description;
  @JsonFormat(pattern = "dd-mm-yyyy")
  private Date startDate;
  @JsonFormat(pattern = "dd-mm-yyyy")
  private Date endDate;
  @JsonFormat(pattern = "dd-mm-yyyy")
  private Date createdAt;
  @JsonFormat(pattern = "dd-mm-yyyy")
  private Date updatedAt;

  public Project() {
  }

  @PrePersist
  protected void onCreate() {
    this.createdAt = new Date();
  }

  @PreUpdate
  protected void onUpdate() {
    this.updatedAt = new Date();
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getProjectName() {
    return this.projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public String getProjectIdentifier() {
    return this.projectIdentifier;
  }

  public void setProjectIdentifier(String projectIdentifier) {
    this.projectIdentifier = projectIdentifier;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getStartDate() {
    return this.startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return this.endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public Date getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return this.updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

}