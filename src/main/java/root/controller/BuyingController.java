package root.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BuyingController {
	@RequestMapping("/cart")
	public String showCart() {
		return "cart";
	}

	@RequestMapping("/checkout")
	public String showCheckout() {
		return "checkout";
	}

	@RequestMapping("/order-complete")
	public String showOrderComplete() {
		return "order-complete";
	}

}
