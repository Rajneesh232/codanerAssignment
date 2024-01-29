package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployees();

	Optional<Employee> getEmployeeById(Long id);

	void addEmployee(Employee employee);

	boolean updateEmployee(Long id, Employee updatedEmployee);

	boolean deleteEmployee(Long id);
}
