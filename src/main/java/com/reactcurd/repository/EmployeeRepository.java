package com.reactcurd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reactcurd.entity.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Long>{

}
