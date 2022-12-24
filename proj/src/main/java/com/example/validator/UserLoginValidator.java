package com.example.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.pojo.User;

public class UserLoginValidator implements Validator{
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Username", "empty-user-name", "First Name cannot be blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Password", "empty-password", "Last Name cannot be blank");
	}
}
