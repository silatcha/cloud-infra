package com.cytech.planing.loginBean;

public class LoginBean {

	
	private String email;
	private String password;
	private String roleUser;
	public LoginBean(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getRoleUser() {
		return roleUser;
	}
	
	
	
}
