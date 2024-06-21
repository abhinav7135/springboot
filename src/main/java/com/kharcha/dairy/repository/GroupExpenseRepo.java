package com.kharcha.dairy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kharcha.dairy.model.GroupExpense;

@Repository
public interface GroupExpenseRepo extends JpaRepository<GroupExpense, Long>{
List<GroupExpense>findByOwnerId(Long ownerId);
List<GroupExpense>findByMembersId(Long userId);
}
