package com.lawrence501.course_q2_2019_java.web;

import javax.validation.Valid;

import com.lawrence501.course_q2_2019_java.domain.User;
import com.lawrence501.course_q2_2019_java.services.MapValidationErrorService;
import com.lawrence501.course_q2_2019_java.services.UserService;
import com.lawrence501.course_q2_2019_java.validator.UserValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
  @Autowired
  private MapValidationErrorService mapValidationErrorService;

  @Autowired
  private UserService userService;

  @Autowired
  private UserValidator userValidator;

  @PostMapping("/register")
  public ResponseEntity<?> registerUser(@Valid @RequestBody User user, BindingResult result) {
    userValidator.validate(user, result);

    ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
    if (errorMap != null) {
      return errorMap;
    }

    User newUser = userService.saveUser(user);
    return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
  }
}