package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Teacher;
import com.example.demo.services.TeacherService;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	@GetMapping
	public List<Teacher> getAllTeachers() {
		return teacherService.getAllTeachers();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id) {
		return teacherService.getTeacherById(id).map(teacher -> new ResponseEntity<>(teacher, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping
	public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
		Teacher savedTeacher = teacherService.createTeacher(teacher);
		return new ResponseEntity<>(savedTeacher, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id, @RequestBody Teacher updatedTeacher) {
		return teacherService.getTeacherById(id).map(teacher -> {
			teacher.setTeacherId(updatedTeacher.getTeacherId());
			teacher.setTeacherName(updatedTeacher.getTeacherName());
			Teacher savedTeacher = teacherService.createTeacher(teacher);
			return new ResponseEntity<>(savedTeacher, HttpStatus.OK);
		}).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTeacher(@PathVariable Long id) {
		if (teacherService.deleteTeacher(id)) {
			return ResponseEntity.ok("Teacher deleted successfully");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
