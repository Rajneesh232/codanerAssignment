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

import com.example.demo.entities.Student;

// StudentController.java
@RestController
@RequestMapping("/students")
public class StudentController {

	private final List<Student> studentList = new ArrayList<>();

	@GetMapping
	public List<Student> getAllStudents() {
		return studentList;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
		Optional<Student> student = studentList.stream().filter(s -> s.getStudentId().equals(id)).findFirst();

		return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<String> addStudent(@RequestBody Student student) {
		studentList.add(student);
		return ResponseEntity.ok("Student added successfully");
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
		for (int i = 0; i < studentList.size(); i++) {
			Student student = studentList.get(i);
			if (student.getStudentId().equals(id)) {
				studentList.set(i, updatedStudent);
				return ResponseEntity.ok("Student updated successfully");
			}
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
		for (Iterator<Student> iterator = studentList.iterator(); iterator.hasNext();) {
			Student student = iterator.next();
			if (student.getStudentId().equals(id)) {
				iterator.remove();
				return ResponseEntity.ok("Student deleted successfully");
			}
		}
		return ResponseEntity.notFound().build();
	}
}
