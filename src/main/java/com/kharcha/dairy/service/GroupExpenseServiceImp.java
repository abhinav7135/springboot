package com.kharcha.dairy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kharcha.dairy.exception.GroupExpenseException;
import com.kharcha.dairy.model.GroupExpense;
import com.kharcha.dairy.model.User;
import com.kharcha.dairy.repository.GroupExpenseRepo;
import com.kharcha.dairy.repository.UserRepo;

@Service
public class GroupExpenseServiceImp implements GroupExpenseService{

	@Autowired
	private GroupExpenseRepo groExpenseRepo;
	
	@Autowired
	private UserRepo userRepo;
	

	public GroupExpense createGroup(String groupName,Long ownerId)
	{
		User owner=userRepo.findById(ownerId).orElseThrow(()->new RuntimeException("User not found"));
		GroupExpense group=new GroupExpense();
		group.setName(groupName);
		group.setOwner(owner);
		return groExpenseRepo.save(group);
	}
	
	
	public GroupExpense addMember(Long groupId,Long userId)
	{
		GroupExpense group=groExpenseRepo.findById(groupId).orElseThrow(()->new RuntimeException("Group not found"));
	    User user=userRepo.findById(userId).orElseThrow(()->new RuntimeException("User not found"));
	group.getMembers().add(user);
	return groExpenseRepo.save(group);
	}
	public  List<GroupExpense>getGroupByUserId(Long userId)
	{
		return groExpenseRepo.findByMembersId(userId);
	}
    

}
