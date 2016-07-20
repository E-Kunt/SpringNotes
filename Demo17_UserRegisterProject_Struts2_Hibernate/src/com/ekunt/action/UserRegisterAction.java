package com.ekunt.action;

import com.ekunt.entity.User;
import com.ekunt.service.UserService;
import com.ekunt.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class UserRegisterAction extends ActionSupport {

	private static final long serialVersionUID = 3959562481663338123L;
	private UserService userService = UserServiceImpl.getInstance();
	private String user, passwd, passwd2;
	
	@Override
	public String execute() throws Exception {
		System.out.println("user:" + user + "\npasswd:" + passwd + "\npasswd2:" + passwd2);
		if(user == null || passwd == null || passwd2 == null) {
			return INPUT;
		} else if(user.equals("") || passwd.equals("") || passwd2.equals("") ) {
			return INPUT;
		}
		if (!passwd.equals(passwd2)) {
			return ERROR;
		}
		User u = new User(user, passwd);
		//检查用户名是否已存在
		if (userService.exist(u)) {
			return ERROR;
		}
		//注册用户，插入数据
		if (!userService.add(u)) {
			return ERROR;
		}
		return SUCCESS;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UserService getUserService() {
		return userService;
	}

	public String getUser() {
		return user;
	}

	public String getPasswd() {
		return passwd;
	}

	public String getPasswd2() {
		return passwd2;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
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
	
}
