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
	// Admin

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

}
