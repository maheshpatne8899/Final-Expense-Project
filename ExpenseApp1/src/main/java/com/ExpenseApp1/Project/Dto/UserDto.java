package com.ExpenseApp1.Project.Dto;

public class UserDto {
	
	
private int userid;
	
	private String username;
	private String email;
	private String password;
	private String confirmPassword;
	public UserDto() {
		super();
	}
	public UserDto(int userid, String username, String email, String password, String confirmPassword) {
		super();
		this.userid = userid;
		this.username = username;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	

}
