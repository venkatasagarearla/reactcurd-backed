package com.reactcurd.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/employee")
public class Employeecontoller {

	@Autowired
	private EmployeeService empService;
	@PostMapping("/addemployee")
	public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto empdto){
      Employee emp=new Employee(empdto.getFirstname(),empdto.getLastname(),empdto.getEmail());
		Employee addedemp=empService.addEmployee(emp);
		EmployeeDto empdt=new EmployeeDto(addedemp.getId(),addedemp.getFirstname(),addedemp.getLastname(),addedemp.getEmail());
		return ResponseEntity.ok(empdt);
		
	}
	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") Long id){

		Employee emp=empService.getEmployeeById(id);
		System.out.println("Empoyee not found");
		EmployeeDto empdt=new EmployeeDto(emp.getId(),emp.getFirstname(),emp.getLastname(),emp.getEmail());
		return ResponseEntity.ok(empdt);
	}
//	public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto dto ){
//		
//		Employee
//	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
		List<Employee> employees=empService.getAllEmployees();
	List<EmployeeDto> empList=employees.stream().map(emp-> new EmployeeDto(emp.getId(),emp.getFirstname(),emp.getLastname(),emp.getEmail())).collect(Collectors.toList());
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
