package model;

public class product {
	private int productId;
	private String name;
	private String description;
	private String imageUrl;
	private double price;
	
	public product() {	
	}
	
	public product(int productId, String name, String description, String imageUrl, double price) {
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.imageUrl = imageUrl;
		this.price = price;
	}
	
	// Accessor/Mutator
	public String getName() {
		return this.name;
	}
	public void setTitle(String name) {
		this.name = name;
	}
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return this.imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getProductId() {
		return this.productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	// Product printOut
	public String toString(){
		return "Product " + this.productId + ": " + this.name + "@" + this.price;
	}
}
