package com.kharcha.dairy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kharcha.dairy.exception.UserException;
import com.kharcha.dairy.model.User;
import com.kharcha.dairy.response.UserResponse;
import com.kharcha.dairy.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public User register(@RequestBody User user)
	{
		return userService.save(user);
	}
}
