package model;

public class packages {
	
	private int tracking_num;
	private String warehouse_address;
	private String delivery_address;
	private int num_goods;

	private String status;
	public packages() {	

	}
	
	public packages(int tracking_num, String warehouse_address, String delivery_address, int num_goods,  String status) {

		this.setWarehouse_address(warehouse_address);
		this.setDelivery_address(delivery_address);
		this.setNum_goods(num_goods);
		this.setTracking_num(tracking_num);
		this.setStatus(status);
	}


	public String getWarehouse_address() {
		return warehouse_address;
	}

	public void setWarehouse_address(String warehouse_address) {
		this.warehouse_address = warehouse_address;
	}

	public String getDelivery_address() {
		return delivery_address;
	}

	public void setDelivery_address(String delivery_address) {
		this.delivery_address = delivery_address;
	}

	public int getNum_goods() {
		return num_goods;
	}

	public void setNum_goods(int num_goods) {
		this.num_goods = num_goods;
	}

	public int getTracking_num() {
		return tracking_num;
	}

	public void setTracking_num(int tracking_num) {
		this.tracking_num = tracking_num;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status2) {
		this.status = status2;
	}

}
