package com.spring.hr.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.spring.hr.mapper.EmployeeMapper;
import com.spring.hr.model.Employee;

@Component
public class EmployeeRepoImpl implements EmployeeRepo{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int count() {
		return jdbcTemplate.queryForObject("select count(*) from employee" , Integer.class);
	}

	@Override
	public Employee findById(Long id) {
		return jdbcTemplate.queryForObject("select id, name , email from employee where id = ?", new Object[] {id} ,
				new EmployeeMapper());
	}

	@Override
	public List<Employee> findAll() {
		return jdbcTemplate.query("select id , name , email from employee", new EmployeeMapper());
	}

	@Override
	public int insert(Employee employee) {
		return jdbcTemplate.update("insert into employee (id, name , email) values (? , ? , ?)" , 
				new Object[] {employee.getId() , employee.getName() , employee.getEmail()});
	}

	@Override
	public int update(Employee employee) {
		return jdbcTemplate.update("update employee set name = ? , email = ?" , 
				new Object[] {employee.getName() , employee.getEmail()});
	}

	@Override
	public int delete(Long id) {
		return jdbcTemplate.update("delete from employee where id = ? " , 
				new Object[] {id});
	}

}
