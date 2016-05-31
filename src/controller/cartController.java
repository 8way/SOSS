package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import dao.loginDaoDB;
import dao.orderDaoDB;
import dao.productDaoDB;
import model.cart;
import model.cartItem;
import model.order;
import model.orderdetail;
import model.product;
import model.user;
import model.warehouse;

@Controller
@RequestMapping("/carts")
@SessionAttributes({"user", "cart"})
public class cartController {

	private final productDaoDB pdao = new productDaoDB();
	private final loginDaoDB udao = new loginDaoDB();
	private final orderDaoDB odao = new orderDaoDB();

	// Home Page
	@ModelAttribute("cart")
	public cart createCart() {
		return new cart();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String show(Model model, @ModelAttribute(value = "cart") cart cart) {
		List<product> products = pdao.getAllProducts();
		model.addAttribute("products", products);
		return "cart";
	}

	@RequestMapping("/add/{productId}")
	public String add(@PathVariable int productId, Model model, @ModelAttribute("cart") cart cart) {

		product p = pdao.getProductById(productId);
		cart.addItem(p); // add the item in cart
		return "cart";
	}

	@RequestMapping("/remove/{productId}")
	public String remove(@PathVariable int productId, Model model, @ModelAttribute("cart") cart cart) {

		product p = pdao.getProductById(productId);
		cart.removeItem(p); // remove the item in cart
		return "cart";
	}

	// Check Availability
	@RequestMapping("/check")
	public String checkAvailability(Model model, @ModelAttribute("cart") cart cart) {
		List<cartItem> userProducts = new ArrayList<cartItem>(cart.getItems());
		String error = "";

		for (cartItem ci : userProducts) {
			int itemStock = pdao.checkInventory(ci);

			if (itemStock == 0) {
				error = ci.getProduct().getName() + " is out of stock, please remove from cart.";
			} else if (itemStock < ci.getQuantity()) {
				error = "We only have " + itemStock + " of book: " + ci.getProduct().getName()
						+ ". Please update your cart to continue.";
			}
		}
		List<product> products = pdao.getAllProducts();
		model.addAttribute("products", products);
		if(error != ""){
			model.addAttribute("error", error);
		}
		return "cart";
	}
}
