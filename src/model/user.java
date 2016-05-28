package model;

public class user {
	private int userId;
	private String userName;
	private boolean isAdmin;
	

	public user(int uid, String usrnm) {
		this.userId = uid;
		this.setUsername(usrnm);
		this.setAdmin(false);
	}

	public user() {
		userName = "";
	}

	// Accessor and Mutator
	
	public String getUserName() {
		return userName;
	}
	public void setUsername(String username) {
		this.userName = username;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
}
