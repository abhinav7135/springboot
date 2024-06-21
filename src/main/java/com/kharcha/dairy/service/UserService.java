package com.kharcha.dairy.service;

import com.kharcha.dairy.model.User;

public interface UserService {

	public User findByEmail(String email);
	public User save(User user);
}
