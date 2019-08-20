package com.lawrence501.course_q2_2019_java.repositories;

import com.lawrence501.course_q2_2019_java.domain.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
  User findByUsername(String username);

  User getById(Long id);
}