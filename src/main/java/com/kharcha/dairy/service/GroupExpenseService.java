package com.kharcha.dairy.service;

import java.util.List;

import com.kharcha.dairy.exception.GroupExpenseException;
import com.kharcha.dairy.model.GroupExpense;

public interface GroupExpenseService {

	public  List<GroupExpense>getGroupByUserId(Long userId);
	public GroupExpense addMember(Long groupId,Long userId);
	public GroupExpense createGroup(String groupName,Long ownerId);
}
