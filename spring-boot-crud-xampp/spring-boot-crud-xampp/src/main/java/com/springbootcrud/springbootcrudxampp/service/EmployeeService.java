package com.springbootcrud.springbootcrudxampp.service;

import java.util.List;

import com.springbootcrud.springbootcrudxampp.model.Employee;


public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	
	Employee getEmployee(int id);
	
	Employee saveEmployee(Employee employee);
	
	Employee updateEmployee(int id,Employee employee);
	
	boolean deleteEmployee(int id);

}
