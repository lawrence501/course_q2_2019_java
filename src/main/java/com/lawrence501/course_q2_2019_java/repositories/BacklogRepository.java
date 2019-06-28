package com.lawrence501.course_q2_2019_java.repositories;

import com.lawrence501.course_q2_2019_java.domain.Backlog;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BacklogRepository extends CrudRepository<Backlog, Long> {
  Backlog findByProjectIdentifier(String projectIdentifier);
}
