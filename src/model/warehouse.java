package model;

public class warehouse {
	private int stock_id;
	private int product_id;
	private String product_name;
	private String location;
	private int qty;

	
	public warehouse() {	
	}
	
	public warehouse(int stock_id, int product_id, String product_name, String location, int qty) {
		this.stock_id = stock_id;
		this.product_id = product_id;
		this.qty = qty;
		this.product_name = product_name;
		this.location = location;
	}

	public int getStock_id() {
		return stock_id;
	}

	public void setStock_id(int stock_id) {
		this.stock_id = stock_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
}
