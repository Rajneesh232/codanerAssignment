package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="employees")
@NoArgsConstructor
@Getter
@Setter
public class Employee {
	@Id
private Long employeeId;
private String employeeName;
private String companyName;
public Employee(Long employeeId, String employeeName, String companyName) {
	super();
	this.employeeId = employeeId;
	this.employeeName = employeeName;
	this.companyName = companyName;
}
public Long getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(Long employeeId) {
	this.employeeId = employeeId;
}
public String getEmployeeName() {
	return employeeName;
}
public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}
public String getCompanyName() {
	return companyName;
}
public void setCompanyName(String companyName) {
	this.companyName = companyName;
}


}
