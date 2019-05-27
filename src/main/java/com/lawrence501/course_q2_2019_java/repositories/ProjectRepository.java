package com.lawrence501.course_q2_2019_java.repositories;

import com.lawrence501.course_q2_2019_java.domain.Project;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
  @Override
  Iterable<Project> findAllById(Iterable<Long> iterable);

}
