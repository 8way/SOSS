package model;

public class order {
	private int order_id;
	private int user_id;
	private String delaaddress;
	private int status;
	public order() {	
	}
	public order(int x, int y,String z, int foo)
	{
		this.setOrder_id(x);
		this.setUser_id(y);
		this.setDelaaddress(z);
		this.setStatus(foo);
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getDelaaddress() {
		return delaaddress;
	}
	public void setDelaaddress(String delaaddress) {
		this.delaaddress = delaaddress;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public boolean pending()
	{
		if (this.status==1)
		{
			return true;
		}
		return false;
	}
}
