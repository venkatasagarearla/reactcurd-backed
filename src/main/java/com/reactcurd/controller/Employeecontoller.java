package com.reactcurd.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactcurd.dto.EmployeeDto;
import com.reactcurd.entity.Employee;
import com.reactcurd.service.EmployeeService;
@CrossOrigin("*")

@RestController
@RequestMapping("/employee")
public class Employeecontoller {

	@Autowired
	private EmployeeService empService;
	//private - you cant access this logger outside the this class
	//static - shared across all the instance of the class .one logger for entire class
	//final - we cant re assign logger to another object
	private static final Logger logger=LoggerFactory.getLogger(Employeecontoller.class);
 
	@PostMapping("/addemployee")
	public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto empdto){
	logger.info(" request received-employee statrted registering");
	
    logger.trace("incoming request {}", empdto);
        Employee emp=new Employee(empdto.getFirstname(),empdto.getLastname(),empdto.getEmail());

		Employee addedemp=empService.addEmployee(emp);
		EmployeeDto empdt=new EmployeeDto(addedemp.getId(),addedemp.getFirstname(),addedemp.getLastname(),addedemp.getEmail());
		logger.debug("employee saved to db:",empdt);
		return ResponseEntity.ok(empdt);
		
		
	}
	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") Long id){
logger .info("fetch employee by id",id);
		Employee emp=empService.getEmployeeById(id);
		System.out.println("Empoyee not found");
		EmployeeDto empdt=new EmployeeDto(emp.getId(),emp.getFirstname(),emp.getLastname(),emp.getEmail());
		logger.debug("employee details {}", empdt);
		return ResponseEntity.ok(empdt);
	}
//	public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto dto ){
//		
//		Employee
//	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
		logger.info("request received to fetch all employees");

		List<Employee> employees=empService.getAllEmployees();
	List<EmployeeDto> empList=employees.stream()
			.map(emp-> new EmployeeDto(emp.getId(),
					emp.getFirstname(),
					emp.getLastname(),
					emp.getEmail())).collect(Collectors.toList());
	logger.debug("all emp {}", empList.size());
	return ResponseEntity.ok(empList);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long id,@RequestBody EmployeeDto empdto ){
	Employee emp=empService.updateEmployee(id,empdto);
	EmployeeDto empdt=new EmployeeDto(emp.getId(),emp.getFirstname(),emp.getLastname(),emp.getEmail());
	return ResponseEntity.ok(empdt);

	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id){
		empService.deleteEmlpoyee(id);
	
		return ResponseEntity.ok("employee deleted sucessfully");
	}
	
}
