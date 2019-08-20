package com.lawrence501.course_q2_2019_java.validator;

import com.lawrence501.course_q2_2019_java.domain.User;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

  @Override
  public boolean supports(Class<?> aClass) {
    return User.class.equals(aClass);
  }

  @Override
  public void validate(Object object, Errors errs) {
    User user = (User) object;
    if (user.getPassword().length() < 6) {
      errs.rejectValue("password", "Length", "Password must be at least 6 characters");
    }
    if (!user.getPassword().equals(user.getConfirmPassword())) {
      errs.rejectValue("confirmPassword", "Match", "Password must match confirm password");
    }
  }

}