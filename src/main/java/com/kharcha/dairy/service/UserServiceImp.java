package com.kharcha.dairy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kharcha.dairy.model.User;
import com.kharcha.dairy.repository.UserRepo;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepo userRepo;
	
//	@Override
//	public User register(User user) throws UserException {
//		User newUser = userRepo.findByEmail(user.getEmail());
//		
//		if(newUser == null) {
//			userRepo.save(user);
//			  return user;
//		}
//		else {
//			throw new UserException("user already exists.");
//	  
//	}	
//	}
//	
//	@Override
//	public UserResponse login(User user) throws UserException{
//		if( !user.getPassword().equals(null) && !user.getPassword().equals("") 
//			&& !user.getEmail().equals(null) && !user.getEmail().equals("")) {
//		User newUser = new User();
//		newUser = userRepo.findByEmail(user.getEmail());
//		UserResponse userRes = new UserResponse();
//		userRes.setId(newUser.getId());
//		userRes.setEmail(newUser.getEmail());
//		userRes.setName(newUser.getName());
//		System.out.println("request:"+user);
//		System.out.println("findbyemail:"+newUser);
////		if(user.getEmail()!=newUser.getEmail() && user.getPassword()!= newUser.getPassword()) {
//		if(!user.getEmail().equals(userRes.getEmail()) && !user.getPassword().equals(userRes.getPassword())) {
//		throw new UserException("Invalid user email and password not matched...");
//		}
//		else {
//		return userRes;
//		     }
//	               }
//		else {
//			throw new UserException("please enter the details email & password");
//		}
//		}
//	


public User save(User user) {
	return userRepo.save(user);
}

public User findByEmail(String email)
{
	return userRepo.findByEmail(email);
}
}

