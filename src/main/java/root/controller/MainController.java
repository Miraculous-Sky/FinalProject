package root.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import root.entity.Cart;
import root.services.BookService;

@Controller
public class MainController {

	@RequestMapping({ "/", "index" })
	public String showIndex(HttpSession session) {
		session.setAttribute("cart", new Cart());
		session.setAttribute("userSession", null);
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

	@RequestMapping("/book")
	public String showProduct(HttpSession session) {
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

	@Autowired
	private BookService bookService;

	@RequestMapping("/search")
	public String searchByName(@RequestParam("bookName") String bookName, Model model) {
		model.addAttribute("books", bookService.findAll(bookName));
		return "/category";
	}
}