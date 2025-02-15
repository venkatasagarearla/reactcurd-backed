package com.reactcurd.service;

import java.util.List;

import com.reactcurd.dto.EmployeeDto;
import com.reactcurd.entity.Employee;

public interface EmployeeService {

	Employee addEmployee(Employee emp);

	Employee getEmployeeById(Long id);

	List<Employee> getAllEmployees();

	Employee updateEmployee(Long id, EmployeeDto empdto);

	void deleteEmlpoyee(Long id);

}
