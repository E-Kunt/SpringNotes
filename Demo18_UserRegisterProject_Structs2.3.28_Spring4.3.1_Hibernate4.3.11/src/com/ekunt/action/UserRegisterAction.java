package com.ekunt.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ekunt.dto.UserDto;
import com.ekunt.entity.User;
import com.ekunt.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 用户注册模块控制器
 * @author E-Kunt
 *
 */
@Component("userRegisterAction")
@Scope("prototype")
public class UserRegisterAction extends ActionSupport implements ModelDriven<UserDto>{

	private static final long serialVersionUID = 3959562481663338123L;
	private UserService userService;
	private UserDto userDto = new UserDto();
	
	@Override
	public String execute() throws Exception {
		System.out.println(userDto);
		if(userDto.getUser() == null || userDto.getPasswd() == null || userDto.getPasswd2() == null) {
			return INPUT;
		} else if(userDto.getUser().equals("") || userDto.getPasswd().equals("") || userDto.getPasswd2().equals("") ) {
			return INPUT;
		}
		if (!userDto.getPasswd().equals(userDto.getPasswd2())) {
			return ERROR;
		}
		User u = new User(userDto.getUser(), userDto.getPasswd());
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
	
	@Override
	public UserDto getModel() {
		return userDto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
