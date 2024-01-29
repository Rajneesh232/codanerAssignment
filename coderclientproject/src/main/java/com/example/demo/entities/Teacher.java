package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="teachers")
@NoArgsConstructor
@Getter
@Setter
public class Teacher {
	@Id
private Long teacherId;
private int assignClassesToTeacher;
private String teacherName;
private String assignCoursesToTeacher;
public Teacher(Long teacherId, int assignClassesToTeacher, String teacherName, String assignCoursesToTeacher) {
	super();
	this.teacherId = teacherId;
	this.assignClassesToTeacher = assignClassesToTeacher;
	this.teacherName = teacherName;
	this.assignCoursesToTeacher = assignCoursesToTeacher;
}
public Long getTeacherId() {
	return teacherId;
}
public void setTeacherId(Long teacherId) {
	this.teacherId = teacherId;
}
public int getAssignClassesToTeacher() {
	return assignClassesToTeacher;
}
public void setAssignClassesToTeacher(int assignClassesToTeacher) {
	this.assignClassesToTeacher = assignClassesToTeacher;
}
public String getTeacherName() {
	return teacherName;
}
public void setTeacherName(String teacherName) {
	this.teacherName = teacherName;
}
public String getAssignCoursesToTeacher() {
	return assignCoursesToTeacher;
}
public void setAssignCoursesToTeacher(String assignCoursesToTeacher) {
	this.assignCoursesToTeacher = assignCoursesToTeacher;
}


}
