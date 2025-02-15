package com.reactcurd.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long id;
    @Column(name="first_name")
	private String firstname;
    @Column(name="last_name")
	private String lastname;
    @Column(name="email_id",nullable = false,unique=true)
	private String email;
    public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(Long id, String firstname, String lastname, String email) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}
	
	public Employee( String firstname, String lastname, String email) {
		super();
	
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}
    
    
	
	
}
