package com.example.demo.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Student;
import com.example.demo.repositories.StudentRepository;
import com.example.demo.services.StudentService;

//StudentServiceImpl.java
@Service
public class StudentServiceImpl implements StudentService {
	
	StudentRepository studentRepository;

	private final List<Student> studentList = new ArrayList<>();

	@Override
	public List<Student> getAllStudents() {
		return studentList;
	}

	@Override
	public Optional<Student> getStudentById(Long id) {
		return studentList.stream().filter(student -> student.getStudentId().equals(id)).findFirst();
	}

	@Override
	public void addStudent(Student student) {
		studentList.add(student);
	}

	@Override
	public boolean updateStudent(Long id, Student updatedStudent) {
		for (int i = 0; i < studentList.size(); i++) {
			Student student = studentList.get(i);
			if (student.getStudentId().equals(id)) {
				studentList.set(i, updatedStudent);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteStudent(Long id) {
		Iterator<Student> iterator = studentList.iterator();
		while (iterator.hasNext()) {
			Student student = iterator.next();
			if (student.getStudentId().equals(id)) {
				iterator.remove();
				return true;
			}
		}
		return false;
	}
}
