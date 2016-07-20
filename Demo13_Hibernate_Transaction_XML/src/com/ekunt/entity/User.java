package com.ekunt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 用户实体类
 * @author E-Kunt
 *
 */
@Entity(name="t_User")
public class User {
	private int id;
	private String name;
	private String password;
	
	public User() {
		super();
	}
	
	public User(String name, String passwd) {
		super();
		this.name = name;
		this.setPassword(passwd);
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
