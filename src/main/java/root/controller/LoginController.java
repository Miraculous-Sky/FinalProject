package root.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import root.model.LoginForm;
import root.validators.LoginFormValidator;

@Controller
public class LoginController {
	private LoginFormValidator loginFormValidator;

	@RequestMapping(value = {"/login"})
	public String validateLogin(Model model, @Validated @ModelAttribute("LoginForm") LoginForm loginForm, BindingResult result,LoginFormValidator loginFormValidator) {
		loginFormValidator.validate(loginForm, result);
		if (result.hasFieldErrors()) {
			return "login-register";
		}
		return "redirect:/index";
	}
}
