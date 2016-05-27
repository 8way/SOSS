package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import model.user;

public class loginDaoDB {
	private String dbPath = "jdbc:sqlite:" + this.getClass().getResource("/").getPath() + "soss.db";
	
	public user login(String username, String password) {
		Connection c = null;
		Statement stmt = null;
		user accountLogin = new user();
		try {
			// Open DB
			Class.forName("org.sqlite.JDBC");

			c = DriverManager.getConnection(dbPath);
			c.setAutoCommit(false);
			stmt = c.createStatement();
			// Run query and get results
			ResultSet rs = stmt.executeQuery("SELECT * FROM accounts WHERE username=\"" +username+ "\"AND password =\""+password+"\";");
			
			if (rs.next()) {
				int uid = rs.getInt(1);
				String usrnm = rs.getString(2);
				accountLogin = new user(uid, usrnm);
			}
			
			rs.close();
			stmt.close();
			c.close();
			
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return accountLogin;
	}
}
