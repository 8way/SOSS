package model;

import java.text.DecimalFormat;

public class cartItem {
	private product item;
	private int quantity;
	
	public cartItem(){			
	}
	
	public cartItem(product p, int q){
		this.item = p;
		this.quantity = q;
	}
	
	// Accessor and Mutator
	public product getProduct() {
		return this.item;
	}
	public void setProduct(product product) {
		this.item = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	// Helper methods
	public double calculateSubTotal() {
		double subTotal = this.item.getPrice() * quantity;
		
		DecimalFormat df = new DecimalFormat("#.##");      
		subTotal = Double.valueOf(df.format(subTotal));
		
		return subTotal;
	}
	
	public void increaseQuantity(){
		quantity++;
	}
	
	public void decreaseQuantity(){
		quantity--;
	}
}
