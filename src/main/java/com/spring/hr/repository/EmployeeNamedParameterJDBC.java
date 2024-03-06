package com.spring.hr.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.hr.mapper.EmployeeMapper;
import com.spring.hr.model.Employee;

@Repository
public class EmployeeNamedParameterJDBC {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public Employee findById(Long id) {
		
		return jdbcTemplate.queryForObject("select id, name, email from employee where id = :id"
				, new MapSqlParameterSource("id" , id) , new EmployeeMapper());
	}
	
	public List<Employee> findByNameAndEmail(String name , String email) {
		
		MapSqlParameterSource mapSql = new MapSqlParameterSource();
		mapSql.addValue("name", name);
		mapSql.addValue("email", email);
		return jdbcTemplate.query("select id , name, email from employee where name= :name and email = :email",
			mapSql	, new EmployeeMapper());
	}
	
	
	
	
}
