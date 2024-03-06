package com.spring.hr.repository;

import java.util.List;

import com.spring.hr.model.Employee;

public interface EmployeeRepo {

	public int count();
	
	public Employee findById(Long id);
	
	public List<Employee> findAll();
	
	public int insert(Employee employee);
	
	public int update(Employee employee);
	
	public int delete(Long id);
	
}
