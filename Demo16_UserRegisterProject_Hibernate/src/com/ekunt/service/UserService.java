package com.ekunt.service;

import com.ekunt.entity.User;

public interface UserService {

	boolean exist(User user);

	boolean add(User user);

}