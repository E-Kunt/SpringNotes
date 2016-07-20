package com.ekunt.service;

import com.ekunt.entity.User;

/**
 * 用户业务逻辑接口
 * @author E-Kunt
 *
 */
public interface UserService {

	boolean exist(User user);

	boolean add(User user);

}