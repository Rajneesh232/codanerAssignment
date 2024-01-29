package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Admin;
import com.example.demo.repositories.AdminRepository;
import com.example.demo.services.AdminService;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;
	private List<Admin> adminList;

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }

    @Override
    public Admin createAdmin(Admin admin) {
        // You may want to hash the password before saving it to the database
        // admin.setAdminPassword(passwordEncoder.encode(admin.getAdminPassword()));
        return adminRepository.save(admin);
    }

    @Override
    public Optional<Admin> updateAdmin(Long id, Admin updatedAdmin) {
        return adminRepository.findById(id)
                .map(admin -> {
                    admin.setAdminName(updatedAdmin.getAdminName());
                    admin.setAdminPassword(updatedAdmin.getAdminPassword());
                    return adminRepository.save(admin);
                });
    }
    
    @Override
    public boolean deleteAdmin(Long id) {
        Iterator<Admin> iterator = adminList.iterator();
        while (iterator.hasNext()) {
            Admin admin = iterator.next();
            if (admin.getAdminId().equals(id)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
