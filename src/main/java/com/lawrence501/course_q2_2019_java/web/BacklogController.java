package com.lawrence501.course_q2_2019_java.web;

import javax.validation.Valid;

import com.lawrence501.course_q2_2019_java.domain.ProjectTask;
import com.lawrence501.course_q2_2019_java.services.MapValidationErrorService;
import com.lawrence501.course_q2_2019_java.services.ProjectTaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/backlog")
@CrossOrigin
public class BacklogController {
  @Autowired
  private ProjectTaskService projectTaskService;
  @Autowired
  private MapValidationErrorService mapValidationErrorService;

  @PostMapping("/{backlogId}")
  public ResponseEntity<?> addTaskToBacklog(@Valid @RequestBody ProjectTask projectTask, BindingResult result,
      @PathVariable String backlogId) {
    ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
    if (errorMap != null) {
      return errorMap;
    }
    ProjectTask newProjectTask = projectTaskService.addProjectTask(backlogId, projectTask);
    return new ResponseEntity<ProjectTask>(newProjectTask, HttpStatus.CREATED);
  }

  @GetMapping("/{backlogId}")
  public ResponseEntity<Iterable<ProjectTask>> getProjectBacklog(@PathVariable String backlogId) {
    return new ResponseEntity<Iterable<ProjectTask>>(projectTaskService.findBacklogById(backlogId), HttpStatus.OK);
  }

  @GetMapping("/{backlogId}/{taskSequence}")
  public ResponseEntity<ProjectTask> getProjectTask(@PathVariable String backlogId, @PathVariable String taskSequence) {
    return new ResponseEntity<ProjectTask>(projectTaskService.findTaskByProjectSequence(backlogId, taskSequence),
        HttpStatus.OK);
  }

  @PatchMapping("/{backlogId}")
  public ResponseEntity<?> updateTask(@Valid @RequestBody ProjectTask newTask, BindingResult result,
      @PathVariable String backlogId) {
    ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
    if (errorMap != null) {
      return errorMap;
    }
    ProjectTask updatedTask = projectTaskService.updateTask(newTask, backlogId);
    return new ResponseEntity<ProjectTask>(updatedTask, HttpStatus.OK);
  }

  @DeleteMapping("/{backlogId}/{taskSequence}")
  public ResponseEntity<?> deleteTask(@PathVariable String backlogId, @PathVariable String taskSequence) {
    projectTaskService.deleteTask(backlogId, taskSequence);
    return new ResponseEntity<String>("Project task '" + taskSequence + "' was deleted successfully", HttpStatus.OK);
  }
}