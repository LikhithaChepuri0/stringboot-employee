package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.exception.EmployeeAlreadyExistsException;
import com.example.demo.service.EmployeeService;



@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeservice;
	
	
	
	@PostMapping("/saveEmployee")
	public Employee saveEmployee(@RequestBody Employee employee) throws EmployeeAlreadyExistsException {
		return employeeservice.saveEmployee(employee);
	}
	
	@GetMapping("/fetch")
	public List<Employee> getAllEmployees(){
		return employeeservice.getAllEmployees();
	}
	
	
	@PutMapping("/update/{id}/{salary}")
	public Employee updateEmployee(@RequestBody Employee employee,@PathVariable int id,@PathVariable Double salary) {
		return employeeservice.updateEmployee(employee,  id, salary);

	}

}
