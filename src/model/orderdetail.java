package model;

public class orderdetail {
	private int orderitem_id;
	private int order_id;
	private int productid;
	private int qty;
	private String name;
	public orderdetail() {	
	}
	public orderdetail(int x, int y,int z, int foo, String bar)
	{
		this.setOrder_id(y);
		this.setOrderitem_id(x);
		this.setProductid(z);
		this.setQty(foo);
		this.setName(bar);
	}
	public int getOrderitem_id() {
		return orderitem_id;
	}
	public void setOrderitem_id(int orderitem_id) {
		this.orderitem_id = orderitem_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
