package com.kharcha.dairy.model;


import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;


@Entity
@Data
public class GroupExpense {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

private String name;

@ManyToOne
@JoinColumn(name="owner_id")
private User owner;

@ManyToMany
@JoinTable(name="group_members",
joinColumns= @JoinColumn(name="group_id"),
inverseJoinColumns=@JoinColumn(name="user_id")
)
private Set<User> members;

}
