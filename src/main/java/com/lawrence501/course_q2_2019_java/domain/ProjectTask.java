package com.lawrence501.course_q2_2019_java.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ProjectTask {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(updatable = false)
  private String projectSequence;
  @NotBlank(message = "Please include a project summary")
  private String summary;
  private String acceptanceCriteria;
  private String status;
  private Integer priority;
  private Date dueDate;
  private Date createdAt;
  private Date updatedAt;
  @Column(updatable = false)
  private String projectIdentifier;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
  @JoinColumn(name = "backlogId", updatable = false, nullable = false)
  @JsonIgnore
  private Backlog backlog;

  @PrePersist
  protected void onCreate() {
    this.createdAt = new Date();
  }

  @PreUpdate
  protected void onUpdate() {
    this.updatedAt = new Date();
  }

  public ProjectTask() {
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getProjectSequence() {
    return this.projectSequence;
  }

  public void setProjectSequence(String projectSequence) {
    this.projectSequence = projectSequence;
  }

  public String getSummary() {
    return this.summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public String getAcceptanceCriteria() {
    return this.acceptanceCriteria;
  }

  public void setAcceptanceCriteria(String acceptanceCriteria) {
    this.acceptanceCriteria = acceptanceCriteria;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Integer getPriority() {
    return this.priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  public Date getDueDate() {
    return this.dueDate;
  }

  public void setDueDate(Date dueDate) {
    this.dueDate = dueDate;
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

  public String getProjectIdentifier() {
    return this.projectIdentifier;
  }

  public void setProjectIdentifier(String projectIdentifier) {
    this.projectIdentifier = projectIdentifier;
  }

  public Backlog getBacklog() {
    return this.backlog;
  }

  public void setBacklog(Backlog backlog) {
    this.backlog = backlog;
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", projectSequence='" + getProjectSequence() + "'" + ", summary='"
        + getSummary() + "'" + ", acceptanceCriteria='" + getAcceptanceCriteria() + "'" + ", status='" + getStatus()
        + "'" + ", priority='" + getPriority() + "'" + ", dueDate='" + getDueDate() + "'" + ", createdAt='"
        + getCreatedAt() + "'" + ", updatedAt='" + getUpdatedAt() + "'" + ", projectIdentifier='"
        + getProjectIdentifier() + "'" + "}";
  }

}