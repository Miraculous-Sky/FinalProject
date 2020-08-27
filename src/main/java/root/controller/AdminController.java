package root.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import root.entity.Book;
import root.entity.User;
import root.services.BookService;
import root.services.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	BookService bookService;
	@Autowired
	UserService userService;

	@GetMapping("/book")
	public String managebook(Model model) {
		List<Book> books = bookService.getAllBook();
		model.addAttribute("books", books);
		return "admin/book-management";
	}

	@GetMapping("/user")
	public String manageUser(Model model) {
		List<User> users = userService.getAllUser();
		model.addAttribute("users", users);
		return "admin/user-management";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteUser(@RequestParam("id") int userId, Model model) {
		userService.deleteUserById(userId);
		List<User> users = userService.getAllUser();
		model.addAttribute("users", users);
		return "admin/user-management";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editUser(@RequestParam("id") int userId, Model model) {
		Optional<User> userEdit = userService.findUserById(userId);
		userEdit.ifPresent(user -> model.addAttribute("user", user));
		return "admin/edituser";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(User user, Model model) {
		userService.save(user);
		List<User> users = userService.getAllUser();
		model.addAttribute("users", users);
		return "admin/user-management";
	}

	@RequestMapping(value = "/add")
	public String addUser(Model model) {
		String username = " ";
		String email = "Email@gmail.com";
		String password = " ";
		String repeatPassword = "......";
		String phoneNumber = "--- --- ----";
		User user = new User();
		model.addAttribute("user", user);
		return "admin/addUser";
	}

	@RequestMapping(value = "/edit_book", method = RequestMethod.GET)
	public String editBook(@RequestParam("id") int bookId, Model model) {
		Optional<Book> bookEdit = bookService.findUserById(bookId);
		bookEdit.ifPresent(user -> model.addAttribute("user", user));
		return "admin/editbook";
	}

	@RequestMapping(value = "/add_book")
	public String addBook(Model model) {
		Book book =new Book();
		model.addAttribute("book", book);
		return "admin/addBook";
	}

	@RequestMapping(value = "/save_book", method = RequestMethod.POST)
	public String saveBook(Book book, Model model) {
		bookService.saveBook(book);
		List<Book> books = bookService.getAllBook();
		model.addAttribute("books", books);
		return "admin/book-management";
	}
	@RequestMapping(value = "/delete_book", method = RequestMethod.GET)
	public String deleteBook(@RequestParam("id") int bookId, Model model) {
		bookService.deleteBookById(bookId);
		List<Book> books = bookService.getAllBook();
		model.addAttribute("books", books);
		return "admin/book-management";
	}

}
