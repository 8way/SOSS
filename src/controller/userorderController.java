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
import org.springframework.web.servlet.ModelAndView;
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
@RequestMapping("/order")
@SessionAttributes({"user"})
public class userorderController {

	private final productDaoDB pdao = new productDaoDB();
	private final loginDaoDB udao = new loginDaoDB();
	private final orderDaoDB odao = new orderDaoDB();

	@RequestMapping(method = RequestMethod.GET)
	public String showAdminPage(Model model, HttpSession session) {
		System.out.println(session.getAttribute("user").toString());
		user sessionuser = (user) session.getAttribute("user");
		
		List<order> orders = odao.getOrderByuid(sessionuser.getUserId());
		model.addAttribute("orders", orders);
//		List<warehouse> warehouses = odao.getAllwarehouse();
//		model.addAttribute("warehouses", warehouses);
		return "myorder";
	}
//	@RequestMapping(value = "/get/{orderid}", method = RequestMethod.GET)
//	public String showOrderdetailPage(@PathVariable int orderid, Model model, @ModelAttribute("order") order order) {
//		List<orderdetail> orders = odao.getOrderDetailsById(orderid);
//		model.addAttribute("orders", orders);
//		List<warehouse> warehouses = odao.getAllwarehouse();
//		model.addAttribute("warehouses", warehouses);
//		System.out.println(onePackage(orders, warehouses));
//		if (onePackage(orders, warehouses) != null)
//		{
//			String place = onePackage(orders, warehouses);
//			
//			model.addAttribute("package", warehouses);
//		}
//		return "orderdetails";
//	}

}
