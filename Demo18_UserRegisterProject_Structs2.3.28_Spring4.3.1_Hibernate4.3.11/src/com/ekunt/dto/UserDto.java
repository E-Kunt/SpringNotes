package com.ekunt.dto;

/**
 * 用户表单数据传输对象
 * @author E-Kunt
 *
 */
public class UserDto {

	private String user, passwd, passwd2;

	public String getUser() {
		return user;
	}

	public String getPasswd() {
		return passwd;
	}

	public String getPasswd2() {
		return passwd2;
	}
	
	public void setUser(String user) {
		this.user = user;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public void setPasswd2(String passwd2) {
		this.passwd2 = passwd2;
	}

	@Override
	public String toString() {
		return "UserDto [user=" + user + ", passwd=" + passwd + ", passwd2=" + passwd2 + "]";
	}
	
}
