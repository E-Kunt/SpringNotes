package com.ekunt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	private int id;
	private String user;
	private String passwd;
	public User() {
	}
	public User(String user, String passwd) {
		this.user = user;
		this.passwd = passwd;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public String getUser() {
		return user;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}
