package root.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import root.model.LoginForm;
@Component
public class LoginFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		LoginForm loginForm = (LoginForm) target;
		//
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmty.loginForm.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.loginForm.email");
		//
		if (loginForm.getPassword().length() < 6) {
			errors.rejectValue("password", "Size.loginForm.password");
		}
	}

}
