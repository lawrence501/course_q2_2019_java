package com.lawrence501.course_q2_2019_java.services;

import com.lawrence501.course_q2_2019_java.domain.Backlog;
import com.lawrence501.course_q2_2019_java.domain.Project;
import com.lawrence501.course_q2_2019_java.exceptions.ProjectIdException;
import com.lawrence501.course_q2_2019_java.repositories.BacklogRepository;
import com.lawrence501.course_q2_2019_java.repositories.ProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
  @Autowired
  private ProjectRepository projectRepository;
  @Autowired
  private BacklogRepository backlogRepository;

  public Project saveOrUpdateProject(Project project) {
    String ucProjectIdentifier = project.getProjectIdentifier().toUpperCase();
    try {
      project.setProjectIdentifier(ucProjectIdentifier);

      // Creating
      if (project.getId() == null) {
        Backlog backlog = new Backlog();
        project.setBacklog(backlog);
        backlog.setProject(project);
        backlog.setProjectIdentifier(ucProjectIdentifier);
      }
      // Updating
      else {
        project.setBacklog(backlogRepository.findByProjectIdentifier(ucProjectIdentifier));
      }

      return projectRepository.save(project);
    } catch (Exception e) {
      throw new ProjectIdException("Project ID '" + ucProjectIdentifier + "' already exists");
    }
  }

  public Project findProjectByIdentifier(String projectId) {
    Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
    if (project == null) {
      throw new ProjectIdException("Project ID '" + projectId.toUpperCase() + "' does not exist");
    }
    return project;
  }

  public Iterable<Project> findAllProjects() {
    return projectRepository.findAll();
  }

  public void deleteProjectByIdentifier(String projectId) {
    Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
    if (project == null) {
      throw new ProjectIdException("Project ID '" + projectId.toUpperCase() + "' does not exist");
    }
    projectRepository.delete(project);
  }
}