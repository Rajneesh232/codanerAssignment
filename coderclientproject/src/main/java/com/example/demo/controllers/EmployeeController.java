package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Employee;

// EmployeeController.java
@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private final List<Employee> employeetList = new ArrayList<>();
	private List<Employee> employeeList;

	@GetMapping
	public List<Employee> getAllEmployees() {
		return employeetList;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getStudentById(@PathVariable Long id) {
		Optional<Employee> employee = employeetList.stream().filter(s -> s.getEmployeeId().equals(id)).findFirst();

		return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
		employeetList.add(employee);
		return ResponseEntity.ok("Employee added successfully");
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
		for (int i = 0; i < employeeList.size(); i++) {
			Employee employee = employeeList.get(i);
			if (employee.getEmployeeId().equals(id)) {
				employeeList.set(i, updatedEmployee);
				return ResponseEntity.ok("Employee updated successfully");
			}
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
		for (Iterator<Employee> iterator = employeeList.iterator(); iterator.hasNext();) {
			Employee employee = iterator.next();
			if (employee.getEmployeeId().equals(id)) {
				iterator.remove();
				return ResponseEntity.ok("Employee deleted successfully");
			}
		}
		return ResponseEntity.notFound().build();

	}

}
