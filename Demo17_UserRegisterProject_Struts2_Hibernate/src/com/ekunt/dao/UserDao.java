package com.ekunt.dao;

import com.ekunt.entity.User;

public interface UserDao {

	boolean exist(User user);

	void save(User user);

}