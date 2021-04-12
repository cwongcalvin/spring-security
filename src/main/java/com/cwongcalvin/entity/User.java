package com.cwongcalvin.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	private String login;
	private String password;
	private String role;
	
	protected User() {
		
	}

	public User(String login, String password, String role) {
		super();
		this.login = login;
		this.password = password;
		this.role = role;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	@Override
	public String toString() {
		return String.format("User [login=%s, password=%s, role=%s]", login, password, role);
	}

}
