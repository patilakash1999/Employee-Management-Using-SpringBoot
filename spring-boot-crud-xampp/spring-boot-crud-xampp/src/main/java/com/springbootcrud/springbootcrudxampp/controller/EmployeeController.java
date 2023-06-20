package com.springbootcrud.springbootcrudxampp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootcrud.springbootcrudxampp.model.Employee;
import com.springbootcrud.springbootcrudxampp.service.EmployeeService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<Employee>> getAllEmployees()
	{
		List<Employee> empList = employeeService.getAllEmployees();
		ResponseEntity<List<Employee>> response = 
				new ResponseEntity<List<Employee>>(empList, HttpStatusCode.valueOf(200));
		return response;
		
	}
	
	@PostMapping(produces = "application/json")
	public ResponseEntity<Employee> saveEmployees(@RequestBody Employee employee)
	{
		Employee emp = employeeService.saveEmployee(employee);
		ResponseEntity<Employee> response = 
				new ResponseEntity<Employee>(emp, HttpStatusCode.valueOf(200));
		return response;
		
	}
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id)
	{
		Employee emp = employeeService.getEmployee(id);
		ResponseEntity<Employee> response = 
				new ResponseEntity<Employee>(emp, HttpStatusCode.valueOf(200));
		return response;
		
	}
	
	@PutMapping(value = "/{id}" , produces = "application/json")
	public ResponseEntity<Employee> updateEmployees(@PathVariable("id") Integer id,
			@RequestBody Employee employee)
	{
		Employee emp = employeeService.updateEmployee(id,employee);
		ResponseEntity<Employee> response = 
				new ResponseEntity<Employee>(emp, HttpStatusCode.valueOf(200));
		return response;
		
	}
	
	@DeleteMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Integer id)
	{
		boolean res = employeeService.deleteEmployee(id);
		String message;
		int status;
		if(res == true)
		{
		message = "employee deleted!";
		status = 200;
		
		} else {
			message = "unable to delete!";
			status = 400;
		}
		ResponseEntity<String> response = 
				new ResponseEntity<String>(message, HttpStatusCode.valueOf(status));
		return response;
		
	}
}
