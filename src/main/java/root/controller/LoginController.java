package root.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import root.entity.User;
import root.model.LoginForm;
import root.services.UserService;

@Controller
public class LoginController {
	@Autowired
	UserService userService;
	User loginUser = new User();
	User registerUser = new User();
	LoginForm loginForm = new LoginForm();

	@RequestMapping({ "/login", "/register" })
	public String showLogin(Model model) {
		model.addAttribute("loginUser", loginUser);
		model.addAttribute("registerUser", registerUser);
		model.addAttribute("loginForm", loginForm);
		return "login-register";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String validateLogin(Model model, @Validated @ModelAttribute("loginForm") LoginForm loginForm,
			BindingResult result) {
		System.out.println(loginForm.getEmail());
		System.out.println(loginForm.getPassword());
		model.addAttribute("registerUser", registerUser);
		if (result.hasErrors()) {
			return "login-register";
		} else {
			if (userService.canLogin(loginForm.getEmail(), loginForm.getPassword())) {
				return "faq";
			} else {
				return "login-register";
			}

		}
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String validateRegister(Model model, @Validated @ModelAttribute("registerUser") User user,
			BindingResult result) {
		model.addAttribute("loginUser", loginUser);
		if (result.hasErrors()) {
			return "login-register";
		} else {
			if (!userService.findByEmail(user.getEmail())) {
				user.setRole("ROLE_USER");
				userService.save(user);
				return "faq";
			} else {
				return "login-register";
			}

		}
	}
}
