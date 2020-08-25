package root.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import root.services.GenreService;

@Controller
public class MainController {

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
