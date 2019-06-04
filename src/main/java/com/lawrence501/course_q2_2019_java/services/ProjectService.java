package com.lawrence501.course_q2_2019_java.services;

import com.lawrence501.course_q2_2019_java.domain.Project;
import com.lawrence501.course_q2_2019_java.exceptions.ProjectIdException;
import com.lawrence501.course_q2_2019_java.repositories.ProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
  @Autowired
  private ProjectRepository projectRepository;

  public Project saveOrUpdateProject(Project project) {
    try {
      project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
      return projectRepository.save(project);
    } catch (Exception e) {
      throw new ProjectIdException("Project ID '" + project.getProjectIdentifier().toUpperCase() + "' already exists");
    }
  }
}