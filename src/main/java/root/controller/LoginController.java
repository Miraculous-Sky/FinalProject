package root.controller;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import root.entity.User;
import root.model.LoginForm;
import root.model.RegisterForm;
import root.services.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;

	@GetMapping({ "/login", "/register" })
	public String showLogin(Model model, @PathParam("error") String error) {
		model.addAttribute("param.error", error);
		model.addAttribute("loginForm", new LoginForm());
		model.addAttribute("registerForm", new RegisterForm());
		return "login-register";
	}

	@PostMapping("/login")
	public String validateLogin(Model model, @Validated @ModelAttribute("loginForm") LoginForm loginForm,
			BindingResult bindingResult, @ModelAttribute("registerForm") RegisterForm registerForm,
			HttpSession session) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("loginForm", loginForm);
			model.addAttribute("registerForm", registerForm);
			return "login-register";
		}
		if (userService.canLogin(loginForm.getLoginEmail(), loginForm.getLoginPassword())) {
			System.out.println(loginForm.getLoginEmail() + loginForm.getLoginPassword());
			User user = userService.findEmail(loginForm.getLoginEmail());
			session.setAttribute("userSession", user);
			if ("ROLE_ADMIN".equalsIgnoreCase(user.getRole()))
				return "admin/book";
			return "index";
		} else {
			return "login-register";
		}
	}

	@PostMapping("/register")
	public String validateRegister(Model model, @Validated @ModelAttribute("registerForm") RegisterForm registerForm,
			BindingResult bindingResult, @ModelAttribute("loginForm") LoginForm loginForm) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("loginForm", loginForm);
			model.addAttribute("registerForm", registerForm);
			return "login-register";
		}
		if (!userService.findByEmail(registerForm.getRegisterEmail())) {
			User user = new User();
			user.setEmail(registerForm.getRegisterEmail());
			user.setFullName(registerForm.getRegisterName());
			user.setPassword(registerForm.getRegisterPassword());
			userService.save(user);
			return "index";
		} else {
			return "login-register";
		}
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("userSession", null);
		return "index";
	}
}
