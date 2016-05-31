package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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
@RequestMapping("/admin")
@SessionAttributes({"user"})
public class adminController {

	private final productDaoDB pdao = new productDaoDB();
	private final loginDaoDB udao = new loginDaoDB();
	private final orderDaoDB odao = new orderDaoDB();

	@RequestMapping(method = RequestMethod.GET)
	public String showAdminPage(Model model) {
		List<order> orders = odao.getAllOrders();
		model.addAttribute("orders", orders);
		List<warehouse> warehouses = odao.getAllwarehouse();
		model.addAttribute("warehouses", warehouses);
		return "admin";
	}
	@RequestMapping(value = "/get/{orderid}", method = RequestMethod.GET)
	public String showOrderdetailPage(@PathVariable int orderid, Model model, @ModelAttribute("order") order order) {
		List<orderdetail> orders = odao.getOrderDetailsById(orderid);
		model.addAttribute("orders", orders);
		List<warehouse> warehouses = odao.getAllwarehouse();
		model.addAttribute("warehouses", warehouses);
		Set<String> x = new HashSet<>();
		for (warehouse y: warehouses)
		{
			x.add(y.getLocation());
		}
		System.out.println(x);
		
		model.addAttribute("string", x);
		System.out.println("can i deliver this in one go");

		return "orderdetails";
	}
	@RequestMapping(value = "/get/{orderid}", method = RequestMethod.POST, params = { "button1id" })
	public String confirmAllOrder(@PathVariable int orderid, Model model, @ModelAttribute("order") order order, HttpServletRequest request) {
		
		System.out.println("aklllllll");
		String location = request.getParameter("select");
		System.out.println(location);
		
		List<orderdetail> orders = odao.getOrderDetailsById(orderid);
		model.addAttribute("orders", orders);
		List<warehouse> warehouses = odao.getAllwarehouse();
		model.addAttribute("warehouses", warehouses);
		Set<String> x = new HashSet<>();
		for (warehouse y: warehouses)
		{
			x.add(y.getLocation());
		}
		model.addAttribute("string", x);
		return "orderdetails";
	}
	@RequestMapping(value = "/get/{orderid}", method = RequestMethod.POST, params = { "button2id" }) //partial
	public String confirmPartOrder(@PathVariable int orderid, Model model, @ModelAttribute("order") order order, HttpServletRequest request) {
		System.out.println("Part");
		String location = request.getParameter("select");
		System.out.println(location);
		
		List<orderdetail> orders = odao.getOrderDetailsById(orderid);
		model.addAttribute("orders", orders);
		List<warehouse> warehouses = odao.getAllwarehouse();
		model.addAttribute("warehouses", warehouses);
		Set<String> x = new HashSet<>();
		for (warehouse y: warehouses)
		{
			x.add(y.getLocation());
		}
		model.addAttribute("string", x);
		return "orderdetails";
	}
//	public String onePackage(List<orderdetail> orders, List<warehouse> warehouses)
//	{
//		Map<String, Map<Integer, Integer>> inve_dic = warehouse2map(warehouses);
//		Map<Integer, Integer> orders_dic = new HashMap<Integer, Integer>();
//		for (orderdetail x: orders)
//		{
//			orders_dic.put(x.getProductid(), x.getQty());
//		}
//		System.out.println(orders_dic.toString());
//		System.out.println(inve_dic.toString());
//		System.out.println(inve_dic.get("Sydney").get(1));
//		for (Entry<String, Map<Integer, Integer>> x:inve_dic.entrySet())
//		{
//			for ( Entry<Integer, Integer> y : orders_dic.entrySet())
//			{
//				if (x.getValue().containsKey(y.getKey()))
//				{
//					if (y.getValue()>x.getValue().get(y.getKey()))
//					{
//						return null;
//					}
//				}
//				else
//				{
//					break;
//				}
//				
//			}
//			return x.getKey();
//			
//		}
//		
//		return null;
//	}
//
//	private Map<String, Map<Integer, Integer>> warehouse2map(List<warehouse> warehouses) {
//		Map<String, Map<Integer, Integer>> inve_dic = new HashMap<String, Map<Integer, Integer>>();
//		Map<Integer, Integer> tmp = new HashMap<Integer, Integer>();
//		for (warehouse x: warehouses)
//		{
//			if (inve_dic.containsKey(x.getLocation()))
//			{
//				inve_dic.get(x.getLocation()).put(x.getProduct_id(), x.getQty());
//			}
//			else
//			{
//				tmp.put(x.getProduct_id(), x.getQty());
//				inve_dic.put(x.getLocation(), tmp);
//				tmp = new HashMap<Integer, Integer>();
//			}
//			
//		}
//		return inve_dic;
//	}
}
