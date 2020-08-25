package root.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import root.model.LoginForm;

@Controller
public class LoginController {

	@GetMapping({ "/login", "/register" })
	public String showLogin(Model model) {
		LoginForm loginForm = new LoginForm();
		model.addAttribute("loginForm", loginForm);
		return "login-register";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String validateLogin(Model model, @Validated @ModelAttribute("loginForm") LoginForm loginForm,
			BindingResult result) {
		if (result.hasErrors()) {
			return "login-register";
		} else {
			return "index";
		}
	}
}
