package root.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import root.services.GenreService;

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
}
