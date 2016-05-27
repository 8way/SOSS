package controller;

import java.util.ArrayList;
import java.util.List;

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
import model.product;
import model.user;

@Controller
@RequestMapping("/")
@SessionAttributes({"user", "cart"})
public class homeController {

	private final productDaoDB pdao = new productDaoDB();
	private final loginDaoDB udao = new loginDaoDB();
	private final orderDaoDB odao = new orderDaoDB();

	// Home Page
	@RequestMapping(method = RequestMethod.GET)
	public String listAll(ModelMap model) {
		List<product> products = pdao.getAllProducts();
		model.addAttribute("products", products);
		return "catalogue";
	}

	// Logout
	@RequestMapping("logout")
	public String logout(Model model, HttpSession session) {
		session.removeAttribute("user");
		if (model.containsAttribute("user")){
			model.asMap().remove("user");
		}
		return "redirect:/";
	}

	// Login Page
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginForm(Model model) {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, Model model) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		user login = udao.login(username, password);
		if (login.getUserName() == "") {
			model.addAttribute("error", "Invalid login, stop being a spazz");
			return "login";
		} else {
			model.addAttribute("user", login);
			return "redirect:/";
		}
	}

	// Delivery Address Page
	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public String showDetailsForm(Model model) {
		return "details";
	}
	
	@RequestMapping(value = "/details", method = RequestMethod.POST)
	public String makeOrder(HttpServletRequest request, Model model, @ModelAttribute("cart") cart cart, @ModelAttribute("user") user user, HttpSession session) {
		// Get all information needed
		int userID = user.getUserId();
		String deladdy = request.getParameter("address");
		
		// Make order 
		if (odao.makeOrder(cart, userID, deladdy)) {
			session.removeAttribute("cart");
			if (model.containsAttribute("cart")){
				model.asMap().remove("cart");
			}
			return "thankyou";
		}
		return "broken";
	}
	
	// Cart Pages
	@ModelAttribute("cart")
	public cart createCart() {
		return new cart();
	}

	@RequestMapping(value="carts", method = RequestMethod.GET)
	public String show(Model model, @ModelAttribute(value = "cart") cart cart) {
		List<product> products = pdao.getAllProducts();
		model.addAttribute("products", products);
		return "cart";
	}

	@RequestMapping("carts/add/{productId}")
	public String add(@PathVariable int productId, Model model, @ModelAttribute("cart") cart cart) {

		product p = pdao.getProductById(productId);
		cart.addItem(p); // add the item in cart
		return "cart";
	}

	@RequestMapping("carts/remove/{productId}")
	public String remove(@PathVariable int productId, Model model, @ModelAttribute("cart") cart cart) {

		product p = pdao.getProductById(productId);
		cart.removeItem(p); // remove the item in cart
		return "cart";
	}

	// Check Availability
	@RequestMapping("carts/check")
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
