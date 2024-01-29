package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Student;

//StudentService.java
public interface StudentService {
	List<Student> getAllStudents();

	Optional<Student> getStudentById(Long id);

	void addStudent(Student student);

	boolean updateStudent(Long id, Student updatedStudent);

	boolean deleteStudent(Long id);
}
