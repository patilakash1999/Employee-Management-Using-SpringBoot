package com.springbootcrud.springbootcrudxampp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootcrud.springbootcrudxampp.dao.EmployeeDao;
import com.springbootcrud.springbootcrudxampp.model.Employee;



@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeDao employeeDao;
	
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeDao.findAll();
	}

	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> empOp = employeeDao.findById(id);
		return empOp.get();
	}

	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.save(employee);
	}

	public Employee updateEmployee(int id,Employee employee) {
		// TODO Auto-generated method stub
		employee.setEmpId(id);
		Optional<Employee> empOp = employeeDao.findById(employee.getEmpId());
		Employee empFromDB = empOp.get();
		
		empFromDB.setEmpName(employee.getEmpName());
		empFromDB.setSalary(employee.getSalary());
		
		Employee savedEmp = employeeDao.save(empFromDB);
		
		return savedEmp;
	}

	public boolean deleteEmployee(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> empOp = employeeDao.findById(id);
		if(empOp.isPresent())
		{
			employeeDao.delete(empOp.get());
			return true;
		}
		return false;
	}

}
