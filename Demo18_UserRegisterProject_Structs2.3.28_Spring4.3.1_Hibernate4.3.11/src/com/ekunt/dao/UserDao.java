package com.ekunt.dao;

import com.ekunt.entity.User;

/**
 * 用户数据访问对象接口
 * @author E-Kunt
 *
 */
public interface UserDao {

	boolean exist(User user);

	void save(User user);

}