package com.example.validation;

import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.example.model.Login;
import com.example.service.LoginServiceInterface;
public class LoginValidation {
	
	@Autowired
    private LoginServiceInterface ls;
	
	public void validate(Object o, Errors errors) {
        Login login = (Login) o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (login.getUsername().length() < 8 || login.getUsername().length() > 15) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        
        if (ls.findLoginDetais(login.getUsername(), login.getPassword()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (login.getPassword().length() < 8 || login.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }
if (!login.getPasswordConfirm().equals(login.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }

}
