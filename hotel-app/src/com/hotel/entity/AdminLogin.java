package com.hotel.entity;

public class AdminLogin 
{
	private String userId;
	
	private String password;
	
	public AdminLogin()
	{
		
	}

	public AdminLogin(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AdminLogin [userId=" + userId + ", password=" + password + "]";
	}

}
