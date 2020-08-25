package root.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import root.model.LoginForm;
import root.services.GenreService;

@Controller
public class MainController {
	@GetMapping({ "/login", "/register" })
	public String showLogin(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		return "login-register";
	}

	@RequestMapping({ "/", "index" })
	public String showIndex() {
		return "index";
	}

	@RequestMapping("/contact")
	public String showContact() {
		return "contact";
	}

	@RequestMapping("/category")
	public String showCategory() {
		return "category";
	}

	@RequestMapping("/cart")
	public String showCart() {
		return "cart";
	}

	@RequestMapping("/book")
	public String showProduct() {
		return "book";
	}

	@RequestMapping("/faq")
	public String showFAQ() {
		return "faq";
	}

	@RequestMapping("/my-account")
	public String showMyAccount() {
		return "my-account";
	}

	@RequestMapping("/logout")
	public String logout() {
		return "index";
	}

	@RequestMapping("/checkout")
	public String showCheckout() {
		return "checkout";
	}

	@RequestMapping("/order-complete")
	public String showOrderComplete() {
		return "order-complete";
	}

	@RequestMapping("/leave-a-message")
	@ResponseBody
	public String sendMessage(HttpServletResponse httpServletResponse) {
		if (new Random().nextInt(2) == 1)
			return "thành công";
		httpServletResponse.setStatus(500);
		return "thất bại";
	}

	@Autowired
	private GenreService genreService;

	@RequestMapping("/get-genre")
	@ResponseBody
	public List<String> getGenre(HttpServletResponse httpServletResponse) {
		return genreService.findAll();
	}
}
