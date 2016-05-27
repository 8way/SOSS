package model;

public class user {
	private int userId;
	private String userName;
	

	public user(int uid, String usrnm) {
		this.userId = uid;
		this.setUsername(usrnm);
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
	
}
