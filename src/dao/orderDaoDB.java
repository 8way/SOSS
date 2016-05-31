package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.cart;
import model.cartItem;
import model.order;
import model.orderdetail;
import model.product;
import model.warehouse;

public class orderDaoDB {
	private String dbPath = "jdbc:sqlite:" + this.getClass().getResource("/").getPath() + "soss.db";

	public boolean makeOrder(cart cart, int uid, String deladdy) {
		Connection c = null;
		Statement stmt = null;
		int oid = 0;

		try {
			// Open DB
			Class.forName("org.sqlite.JDBC");

			c = DriverManager.getConnection(dbPath);
			c.setAutoCommit(true);
			stmt = c.createStatement();
			
			List<cartItem> orderProducts = new ArrayList<cartItem>(cart.getItems());
			
			// Make order
			String sql = "INSERT INTO orders (userid, deladdress, status) "
					+ "VALUES ("+uid+",\""+deladdy+"\",1);";
			stmt.executeUpdate(sql);
			
			// Get orderid
			ResultSet rs = stmt.executeQuery("SELECT * FROM orders WHERE userid="+uid+";");
			if (rs.next()) {
				oid = rs.getInt(1);
			}
			
			// Make order items and update inventory
			for(cartItem ci: orderProducts) {
				sql = "INSERT INTO orderitems (orderid, productid, qty) " + 
						"VALUES (" +oid+ "," +ci.getProduct().getProductId() +","+ ci.getQuantity()+");";
				stmt.executeUpdate(sql);
				
				
				int inventoryLeft = 0;
				// Get qty
				sql = "SELECT * FROM inventory WHERE productid=" +ci.getProduct().getProductId()+ ";";
				rs = stmt.executeQuery(sql);
				if(rs.next()) {
					inventoryLeft = rs.getInt(3);
				}
				
				int newInventory = inventoryLeft - ci.getQuantity();
				
				
				sql = "UPDATE inventory SET qty =" +newInventory+ " WHERE productid=" +ci.getProduct().getProductId() +";";
				stmt.executeUpdate(sql);
			}
			
			// Close connection
			rs.close();
			stmt.close();
			c.close();

			return true;

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return false;
	}
	public List<warehouse> getAllwarehouse()
	{
		Connection c = null;
		Statement stmt = null;
		List<warehouse> listOfwarehouses = new ArrayList<warehouse>();

		try {
			// Open DB
			Class.forName("org.sqlite.JDBC");

			c = DriverManager.getConnection(dbPath);
			c.setAutoCommit(false);
			stmt = c.createStatement();

			// Run query and get results
			ResultSet rs = stmt.executeQuery("select stock_id, product_id, name, location, qty from warehouse join product on (warehouse.product_id = product.productid);");

			// Save results into list of products
			while (rs.next()) {
				int x = rs.getInt(1);
				int y = rs.getInt(2);
				String z = rs.getString(3);
				String foo = rs.getString(4);
				int bar = rs.getInt(5);

				warehouse temp = new warehouse(x, y, z, foo, bar);
				listOfwarehouses.add(temp);
			}

			// Close connection
			rs.close();
			stmt.close();
			c.close();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return listOfwarehouses;
	}
	public List<warehouse> getWarehouse(String name)
	{
		Connection c = null;
		Statement stmt = null;
		List<warehouse> listOfwarehouses = new ArrayList<warehouse>();

		try {
			// Open DB
			Class.forName("org.sqlite.JDBC");

			c = DriverManager.getConnection(dbPath);
			c.setAutoCommit(false);
			stmt = c.createStatement();

			// Run query and get results
			ResultSet rs = stmt.executeQuery("select stock_id, product_id, name, location, qty from warehouse join product on (warehouse.product_id = product.productid) where location="+name+";");

			// Save results into list of products
			while (rs.next()) {
				int x = rs.getInt(1);
				int y = rs.getInt(2);
				String z = rs.getString(3);
				String foo = rs.getString(4);
				int bar = rs.getInt(5);

				warehouse temp = new warehouse(x, y, z, foo, bar);
				listOfwarehouses.add(temp);
			}

			// Close connection
			rs.close();
			stmt.close();
			c.close();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return listOfwarehouses;
	}
	public List<order> getAllOrders() {
		Connection c = null;
		Statement stmt = null;
		List<order> listOfOrders = new ArrayList<order>();

		try {
			// Open DB
			Class.forName("org.sqlite.JDBC");

			c = DriverManager.getConnection(dbPath);
			c.setAutoCommit(false);
			stmt = c.createStatement();

			// Run query and get results
			ResultSet rs = stmt.executeQuery("SELECT * FROM orders;");

			// Save results into list of products
			while (rs.next()) {
				int x = rs.getInt(1);
				int y = rs.getInt(2);
				String z = rs.getString(3);
				int foo = rs.getInt(4);

				order temp = new order(x, y, z, foo);
				listOfOrders.add(temp);
			}

			// Close connection
			rs.close();
			stmt.close();
			c.close();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return listOfOrders;
	}
	
	public order getOrderById(int orderId) {
		Connection c = null;
		Statement stmt = null;
		order temp = null;

		try {
			// Open DB
			Class.forName("org.sqlite.JDBC");

			c = DriverManager.getConnection(dbPath);
			c.setAutoCommit(false);
			stmt = c.createStatement();
		
			// Run query and get results
			ResultSet rs = stmt.executeQuery("SELECT * FROM orders WHERE orderid =" + orderId + ";");

			// Save results into list of products
			if (rs.next()) {
				int x = rs.getInt(1);
				int y = rs.getInt(2);
				String z = rs.getString(3);
				int foo = rs.getInt(4);


				temp = new order(x, y, z, foo);
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
	public List<order> getOrderByuid(int user_id) {
		Connection c = null;
		Statement stmt = null;
		List<order> listOfOrders = new ArrayList<order>();
		try {
			// Open DB
			Class.forName("org.sqlite.JDBC");

			c = DriverManager.getConnection(dbPath);
			c.setAutoCommit(false);
			stmt = c.createStatement();
		
			// Run query and get results
			ResultSet rs = stmt.executeQuery("SELECT * FROM orders WHERE userid =" + user_id + ";");

			// Save results into list of products
			while (rs.next()) {
				int x = rs.getInt(1);
				int y = rs.getInt(2);
				String z = rs.getString(3);
				int foo = rs.getInt(4);

				order temp = new order(x, y, z, foo);
				listOfOrders.add(temp);
			}

			// Close connection
			rs.close();
			stmt.close();
			c.close();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return listOfOrders;
	}
	public List<orderdetail> getOrderDetailsById(int orderId) {
		Connection c = null;
		Statement stmt = null;
		List<orderdetail> listOfOrders = new ArrayList<orderdetail>();

		try {
			// Open DB
			Class.forName("org.sqlite.JDBC");

			c = DriverManager.getConnection(dbPath);
			c.setAutoCommit(false);
			stmt = c.createStatement();

			// Run query and get results
			ResultSet rs = stmt.executeQuery("select orderitemid, orderid, orderitems.productid, qty, name from orderitems join product on (orderitems.productid = product.productid) where orderid =" + orderId +";");

			// Save results into list of products
			while (rs.next()) {
				int orderitem_id=rs.getInt(1);
				int order_id=rs.getInt(2);
				int productid=rs.getInt(3);
				int qty=rs.getInt(4);
				String names= rs.getString(5);

				orderdetail temp = new orderdetail(orderitem_id, order_id, productid, qty, names);
				listOfOrders.add(temp);
			}

			// Close connection
			rs.close();
			stmt.close();
			c.close();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return listOfOrders;
	}
}
