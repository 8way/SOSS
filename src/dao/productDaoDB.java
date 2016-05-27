package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.cartItem;
import model.product;

public class productDaoDB {
	private String dbPath = "jdbc:sqlite:" + this.getClass().getResource("/").getPath() + "soss.db";

	public List<product> getAllProducts() {
		Connection c = null;
		Statement stmt = null;
		List<product> listOfProducts = new ArrayList<product>();

		try {
			// Open DB
			Class.forName("org.sqlite.JDBC");

			c = DriverManager.getConnection(dbPath);
			c.setAutoCommit(false);
			stmt = c.createStatement();

			// Run query and get results
			ResultSet rs = stmt.executeQuery("SELECT * FROM product;");

			// Save results into list of products
			while (rs.next()) {
				int id = rs.getInt(1);
				double price = rs.getDouble(2);
				String name = rs.getString(3);
				String description = rs.getString(4);
				String picture = rs.getString(5);

				product temp = new product(id, name, description, picture, price);
				listOfProducts.add(temp);
			}

			// Close connection
			rs.close();
			stmt.close();
			c.close();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return listOfProducts;
	}

	public product getProductById(int productId) {
		Connection c = null;
		Statement stmt = null;
		product temp = null;

		try {
			// Open DB
			Class.forName("org.sqlite.JDBC");

			c = DriverManager.getConnection(dbPath);
			c.setAutoCommit(false);
			stmt = c.createStatement();
		
			// Run query and get results
			ResultSet rs = stmt.executeQuery("SELECT * FROM product WHERE productid =" + productId + ";");

			// Save results into list of products
			if (rs.next()) {
				int id = rs.getInt(1);
				double price = rs.getDouble(2);
				String name = rs.getString(3);
				String description = rs.getString(4);
				String picture = rs.getString(5);

				temp = new product(id, name, description, picture, price);

			}

			// Close connection
			rs.close();
			stmt.close();
			c.close();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return temp;
	}
	
	public int checkInventory(cartItem ci) {
		product p = ci.getProduct();
		int productId = p.getProductId();
		int inStock = 0;
		Connection c = null;
		Statement stmt = null;
		product temp = null;

		try {
			// Open DB
			Class.forName("org.sqlite.JDBC");

			c = DriverManager.getConnection(dbPath);
			c.setAutoCommit(false);
			stmt = c.createStatement();
		
			// Run query and get results
			ResultSet rs = stmt.executeQuery("SELECT * FROM inventory WHERE productid =" + productId + ";");
			
			// Count Stock
			while (rs.next()) {
				inStock += rs.getInt(3);
			}

			// Close connection
			rs.close();
			stmt.close();
			c.close();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return inStock;
	}

	public void updateProduct(product p) {
		// TODO Auto-generated method stub

	}

	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub

	}
	
	public void addProduct(product p) {
		// TODO Auto-generated method stub

	}


}
