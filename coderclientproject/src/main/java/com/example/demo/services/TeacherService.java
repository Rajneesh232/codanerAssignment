package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Teacher;


public interface TeacherService {
	
	List<Teacher> getAllTeachers();

    Optional<Teacher> getTeacherById(Long id);

    Teacher createTeacher(Teacher techer);

    Optional<Teacher> updateTeacher(Long id, Teacher updatedTeacher);

    boolean deleteTeacher(Long id);
}
