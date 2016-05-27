package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.cart;
import model.cartItem;

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
			String sql = "INSERT INTO orders (userid, deladdress, status, tracknumber) "
					+ "VALUES ("+uid+",\""+deladdy+"\",1,1);";
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
}
