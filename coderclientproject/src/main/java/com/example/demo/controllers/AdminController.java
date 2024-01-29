package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Admin;
import com.example.demo.repositories.AdminRepository;
import com.example.demo.services.AdminService;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping
	public List<Admin> getAllAdmins() {
		return adminService.getAllAdmins();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
		return adminService.getAdminById(id).map(admin -> new ResponseEntity<>(admin, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping
	public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
		// You may want to hash the password before saving it to the database
		// admin.setAdminPassword(passwordEncoder.encode(admin.getAdminPassword()));
		Admin savedAdmin = adminService.createAdmin(admin);
		return new ResponseEntity<>(savedAdmin, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin updatedAdmin) {
		return adminService.getAdminById(id).map(admin -> {
			admin.setAdminName(updatedAdmin.getAdminName());
			admin.setAdminPassword(updatedAdmin.getAdminPassword());
			Admin savedAdmin = adminService.createAdmin(admin);
			return new ResponseEntity<>(savedAdmin, HttpStatus.OK);
		}).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable Long id) {
        if (adminService.deleteAdmin(id)) {
            return ResponseEntity.ok("Admin deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
