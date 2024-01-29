package com.example.demo.serviceImpl;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Teacher;
import com.example.demo.repositories.TeacherRepository;
import com.example.demo.services.TeacherService;
@Service
public class TeacherServiceImpl implements TeacherService{

	TeacherRepository teacherRepository;
	
	private List<Teacher> teacherList;
	
	@Override
	public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
	}

	@Override
	public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepository.findById(id);
	}

	@Override
	public Teacher createTeacher(Teacher teacher) {
		 return teacherRepository.save(teacher);
		 }

	@Override
	public Optional<Teacher> updateTeacher(Long id, Teacher updatedTeacher) {
		   return teacherRepository.findById(id)
	                .map(teacher -> {
	                	teacher.setTeacherName(updatedTeacher.getTeacherName());
	                	teacher.setTeacherId(updatedTeacher.getTeacherId());
	                    return teacherRepository.save(teacher);
	                });
	}

	@Override
	public boolean deleteTeacher(Long id) {
		   Iterator<Teacher> iterator = teacherList.iterator();
	        while (iterator.hasNext()) {
	        	Teacher teacher = iterator.next();
	            if (teacher.getTeacherId().equals(id)) {
	                iterator.remove();
	                return true;
	            }
	        }
	        return false;
	    }

}
