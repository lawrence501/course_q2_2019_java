package com.lawrence501.course_q2_2019_java.services;

import com.lawrence501.course_q2_2019_java.domain.Backlog;
import com.lawrence501.course_q2_2019_java.domain.Project;
import com.lawrence501.course_q2_2019_java.domain.ProjectTask;
import com.lawrence501.course_q2_2019_java.exceptions.ProjectNotFoundException;
import com.lawrence501.course_q2_2019_java.repositories.BacklogRepository;
import com.lawrence501.course_q2_2019_java.repositories.ProjectRepository;
import com.lawrence501.course_q2_2019_java.repositories.ProjectTaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskService {
  @Autowired
  private BacklogRepository backlogRepository;
  @Autowired
  private ProjectTaskRepository projectTaskRepository;
  @Autowired
  private ProjectRepository projectRepository;

  public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask) {
    projectIdentifier = projectIdentifier.toUpperCase();
    Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier);
    if (backlog == null) {
      throw new ProjectNotFoundException("Project '" + projectIdentifier + "' does not exist");
    }
    projectTask.setBacklog(backlog);

    Integer backlogSequence = backlog.getPTSequence();
    backlogSequence++;
    projectTask.setProjectSequence(projectIdentifier + "-" + backlogSequence);
    projectTask.setProjectIdentifier(projectIdentifier);
    backlog.setPTSequence(backlogSequence);

    if (projectTask.getPriority() == null) {
      projectTask.setPriority(3);
    }
    if (projectTask.getStatus() == "" || projectTask.getStatus() == null) {
      projectTask.setStatus("TODO");
    }

    return projectTaskRepository.save(projectTask);
  }

  public Iterable<ProjectTask> findBacklogById(String projectIdentifier) {
    Project project = projectRepository.findByProjectIdentifier(projectIdentifier);
    if (project == null) {
      throw new ProjectNotFoundException("Project '" + projectIdentifier + "' does not exist");
    }
    return projectTaskRepository.findByProjectIdentifierOrderByPriority(projectIdentifier);
  }
}