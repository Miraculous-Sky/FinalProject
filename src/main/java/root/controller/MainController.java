package root.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@GetMapping({ "/login", "/register" })
	public String showLogin() {
		return "login-register";
	}

	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}

	@RequestMapping("/contact")
	public String showContact() {
		return "contact";
	}

	@RequestMapping("/product")
	public String showProduct() {
		return "product";
	}
}
