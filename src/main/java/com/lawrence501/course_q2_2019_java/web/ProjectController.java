package com.lawrence501.course_q2_2019_java.web;

import javax.validation.Valid;

import com.lawrence501.course_q2_2019_java.domain.Project;
import com.lawrence501.course_q2_2019_java.services.ProjectService;
import com.lawrence501.course_q2_2019_java.services.MapValidationErrorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
  @Autowired
  private MapValidationErrorService mapValidationErrorService;
  @Autowired
  private ProjectService projectService;

  @PostMapping("")
  public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result) {
    ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
    if (errorMap != null) return errorMap;

    project = projectService.saveOrUpdateProject(project);
    return new ResponseEntity<Project>(project, HttpStatus.CREATED);
  }
}