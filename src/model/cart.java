package model;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class cart {
	private Map<Integer,cartItem> carts;

	public cart(){
		carts = new HashMap<Integer,cartItem>();
	}

	// Show everything in cart
	public Collection<cartItem> getItems() {
		return carts.values();
	}
	
	public boolean isEmpty() {
		return !carts.isEmpty();
	}
	
	// Calculate total
	public double getTotal(){
		double total = 0.0;
		for (cartItem ci: carts.values()){
			total += ci.calculateSubTotal();
		}
		
		DecimalFormat df = new DecimalFormat("#.##");      
		total = Double.valueOf(df.format(total));

		return total;
	}
	
	// Functions to add and remove from cart
	public void addItem(product p){
		int productId = p.getProductId();
		cartItem ci = carts.get(productId);
		if (ci == null){
			carts.put(productId, new cartItem(p,1)); // add the new product			
		}else{ // increase the quantity
			ci.increaseQuantity();
		}
	}
	
	public void removeItem(product p) {
		int productId = p.getProductId();
		cartItem ci = carts.get(productId); 
		
		ci.decreaseQuantity();
		
		if (ci.getQuantity() == 0) {
			carts.remove(productId);
		}
	}
}
