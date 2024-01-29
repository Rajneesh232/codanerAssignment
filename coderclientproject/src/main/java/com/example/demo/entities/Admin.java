package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="admin")
@NoArgsConstructor
@Getter
@Setter
public class Admin {
	@Id
private Long adminId;
private String adminName;
private String adminPassword;
public Admin(Long adminId, String adminName, String adminPassword) {
	super();
	this.adminId = adminId;
	this.adminName = adminName;
	this.adminPassword = adminPassword;
}
public Long getAdminId() {
	return adminId;
}
public void setAdminId(Long adminId) {
	this.adminId = adminId;
}
public String getAdminName() {
	return adminName;
}
public void setAdminName(String adminName) {
	this.adminName = adminName;
}
public String getAdminPassword() {
	return adminPassword;
}
public void setAdminPassword(String adminPassword) {
	this.adminPassword = adminPassword;
}

}
