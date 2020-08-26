package root.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import root.services.GenreService;
import root.services.UserService;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@RequestMapping("/leave-a-message")
	public String sendMessage(HttpServletResponse httpServletResponse) {
		if (new Random().nextInt(2) == 1)
			return "thành công";
		httpServletResponse.setStatus(500);
		return "thất bại";
	}

	@Autowired
	private GenreService genreService;

	@RequestMapping("/get-genre")
	public List<String> getGenre() {
		return genreService.getNameAll();
	}

	@Autowired
	private UserService userService;

	@GetMapping("/check-email")
	public boolean isEmailExist(@PathParam("email") String email) {
		return userService.findByEmail(email);
	}
}
