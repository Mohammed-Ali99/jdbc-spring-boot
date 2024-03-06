package com.spring.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.hr.model.Employee;
import com.spring.hr.repository.EmployeeRepo;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
 
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@GetMapping("/count")
	public int countEmployees() {
		return employeeRepo.count();
	}
	
	@GetMapping("{id}")
	public Employee findById(@PathVariable Long id) {
		return employeeRepo.findById(id);
	}
	
	@GetMapping("")
	public List<Employee> findAll() {
		return employeeRepo.findAll();
	}
	
	

}
