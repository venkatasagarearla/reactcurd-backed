package com.reactcurd.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactcurd.dto.EmployeeDto;
import com.reactcurd.entity.Employee;
import com.reactcurd.exception.EmployeeCreationException;
import com.reactcurd.exception.ResourceNotFoundException;
import com.reactcurd.repository.EmployeeRepository;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
	private final static Logger logger=LoggerFactory.getLogger(EmployeeServiceImplementation.class);
	@Autowired
	private EmployeeRepository emprepo;
	@Override
	public Employee addEmployee(Employee emp) {
		try {
			return emprepo.save(emp);
		}catch(Exception e) {
			logger.error("exception while creating the employee {}",e.getMessage());
			throw new EmployeeCreationException("Failed to save employee: " + e.getMessage());
		}
		
		
	}
	@Override
	public Employee getEmployeeById(Long id) {
	    Employee emp=emprepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee is not exist with given id"+id));
	    
		return emp;
	}
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> emp=emprepo.findAll();
		return emp;
	}
	@Override
	public Employee updateEmployee(Long id, EmployeeDto empdto) {
		Employee emp=emprepo.findById(id).orElseThrow(()->  new ResourceNotFoundException("Employee is not exist with given id"+id));
		emp.setEmail(empdto.getEmail());
		emp.setFirstname(empdto.getFirstname());
		emp.setLastname(empdto.getLastname());
		Employee updateEmp=emprepo.save(emp);
		return updateEmp;
	}
	@Override
	public void deleteEmlpoyee(Long id) {
		logger.warn("employee details will delete",id);
		Employee emp=emprepo.findById(id).orElseThrow(()->  new ResourceNotFoundException("Employee is not exist with given id"+id));
		emprepo.deleteById(id);
		
	}

	
}
