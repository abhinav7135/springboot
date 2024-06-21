package com.kharcha.dairy.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kharcha.dairy.exception.GroupExpenseException;
import com.kharcha.dairy.model.GroupExpense;
import com.kharcha.dairy.model.User;
import com.kharcha.dairy.repository.UserRepo;
import com.kharcha.dairy.service.GroupExpenseService;

@RestController
@RequestMapping("/api/group")
public class GroupExpenseController {

	@Autowired
	private GroupExpenseService groupExpenseService;
	
	@Autowired 
	private UserRepo userRepo;
	
	@PostMapping("/create")
	public GroupExpense createGroupExpenseServive(@RequestParam String name,String email)
	{
		User user = userRepo.findByEmail(email);
		Long ownerId = user.getId();
//		Long ownerId=Long.parseLong(principal.getName());
		return groupExpenseService.createGroup(name,ownerId);
	}

	@PostMapping("/{groupId}/add-memeber")
	public GroupExpense addMember(@PathVariable Long groupId, @RequestParam Long userId)
	{
		return groupExpenseService.addMember(groupId,userId);
	}
	
	@GetMapping
	public List<GroupExpense> getGroups(@RequestParam String email)
	{
		User user = userRepo.findByEmail(email);
		Long userId = user.getId();
//		Long userId=Long.parseLong(principal.getName());
		return groupExpenseService.getGroupByUserId(userId);
	}
}
