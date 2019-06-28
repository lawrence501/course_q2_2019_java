package com.lawrence501.course_q2_2019_java.repositories;

import java.util.List;

import com.lawrence501.course_q2_2019_java.domain.ProjectTask;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTaskRepository extends CrudRepository<ProjectTask, Long> {
  List<ProjectTask> findByProjectIdentifierOrderByPriority(String projectIdentifier);
}
