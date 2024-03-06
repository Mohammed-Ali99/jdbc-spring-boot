package com.spring.hr.model;

public class Employee {

	private Long id;
	
	private String name;
	
	private String email;

	public Long getId() {
		return id;
	}
	
	

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Employee(Long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}



	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
