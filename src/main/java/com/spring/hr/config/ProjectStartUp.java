package com.spring.hr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.spring.hr.model.Employee;
import com.spring.hr.repository.EmployeeRepo;

@Component
public class ProjectStartUp implements CommandLineRunner{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		jdbcTemplate.execute("DROP TABLE IF EXISTS employee");
		jdbcTemplate.execute("create table employee(id SERIAL , name VARCHAR(255) , email VARCHAR(255))");
		
		if(employeeRepo.count() == 0) {
			employeeRepo.insert(new Employee(1L , "mohamed" , "mohamed@gmail.com"));
			employeeRepo.insert(new Employee(2L , "ali" , "ali@gmail.com"));
			employeeRepo.insert(new Employee(3L , "ahmed" , "ahmed@gmail.com"));

		}
		
		
	}

}
