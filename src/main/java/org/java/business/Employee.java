package org.java.business;

import java.time.LocalDate;

public class Employee {
	private String name;
	private String lastname;
	private LocalDate dateOfBirth;
	private String role;
	
	public Employee() {}
	
	public Employee(String name, String lastname, LocalDate dateofBirth, String role) throws Exception {
		setName(name);
		setLastname(lastname);
		setDateOfBirth(dateofBirth);
		setRole(role);
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) throws Exception {
		if (name.isBlank()) {
			throw new Exception("Insert a valid name");
		}
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) throws Exception {
		if (lastname.isBlank()) {
			throw new Exception("Insert a valid lastname");
		}
		this.lastname = lastname;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) throws Exception {
		LocalDate today = LocalDate.now();
		
		if (today.isBefore(dateOfBirth)) {
			throw new Exception("Your date of birth must be in the past");
		}
		
		this.dateOfBirth = dateOfBirth;
	}
	public String getRole() {
		
		return role;
	}
	public void setRole(String role) throws Exception {
		
		if (!(role.equals("employee")) && !(role.equals("boss"))) {
			throw new Exception("Insert a valid role (employee or boss)");
		}
		
		this.role = role;
	}

	
	
	
	
}
