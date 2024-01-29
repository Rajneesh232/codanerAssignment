package com.example.demo.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Employee;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.services.EmployeeService;

//EmployeeServiceImpl.java
@Service
public class EmployeeServiceImpl implements EmployeeService{

		
	  EmployeeRepository employeeRepository;

		private final List<Employee> employeeList = new ArrayList<>();

		@Override
		public List<Employee> getAllEmployees() {
			return employeeList;
		}

		@Override
		public Optional<Employee> getEmployeeById(Long id) {
			return employeeList.stream().filter(employee -> employee.getEmployeeId().equals(id)).findFirst();
		}

		@Override
		public void addEmployee(Employee employee) {
			employeeList.add(employee);
		}

		@Override
		public boolean updateEmployee(Long id, Employee updatedEmployee) {
			for (int i = 0; i < employeeList.size(); i++) {
				Employee student = employeeList.get(i);
				if (student.getEmployeeId().equals(id)) {
					employeeList.set(i, updatedEmployee);
					return true;
				}
			}
			return false;
		}

		@Override
		public boolean deleteEmployee(Long id) {
			Iterator<Employee> iterator = employeeList.iterator();
			while (iterator.hasNext()) {
				Employee employee = iterator.next();
				if (employee.getEmployeeId().equals(id)) {
					iterator.remove();
					return true;
				}
			}
			return false;
		}
	

}
