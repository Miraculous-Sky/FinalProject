package root.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/admin")
public class AdminController {

	@GetMapping("/book")
	public String showLogin() {
		return "admin/book";
	}
}
