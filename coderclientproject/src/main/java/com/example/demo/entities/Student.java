package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="students")
@NoArgsConstructor
@Getter
@Setter
public class Student {
	@Id
private Long studentId;
private String studentName;
private String studentClass;
private String studentSchool;
private Long attendedClasses;
private Long atandencePercentage;


public Student(Long studentId, String studentName, String studentClass, String studentSchool, Long attendedClasses,
		Long atandencePercentage) {
	super();
	this.studentId = studentId;
	this.studentName = studentName;
	this.studentClass = studentClass;
	this.studentSchool = studentSchool;
	this.attendedClasses = attendedClasses;
	this.atandencePercentage = atandencePercentage;
}


public Long getStudentId() {
	return studentId;
}


public void setStudentId(Long studentId) {
	this.studentId = studentId;
}


public String getStudentName() {
	return studentName;
}


public void setStudentName(String studentName) {
	this.studentName = studentName;
}


public String getStudentClass() {
	return studentClass;
}


public void setStudentClass(String studentClass) {
	this.studentClass = studentClass;
}


public String getStudentSchool() {
	return studentSchool;
}


public void setStudentSchool(String studentSchool) {
	this.studentSchool = studentSchool;
}


public Long getAttendedClasses() {
	return attendedClasses;
}


public void setAttendedClasses(Long attendedClasses) {
	this.attendedClasses = attendedClasses;
}


public Long getAtandencePercentage() {
	return atandencePercentage;
}


public void setAtandencePercentage(Long atandencePercentage) {
	this.atandencePercentage = atandencePercentage;
}


}
