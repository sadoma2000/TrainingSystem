package com.Training_System.controller.impl;


import com.Training_System.model.AppUser;
import com.Training_System.service.impl.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    //Only used to add the first admin, just here to make tests easier
    @PostMapping("/register-admin")
    public ResponseEntity registerAdmin(@Valid @RequestBody AppUser admin) {
        adminService.registerAdmin(admin);
        return ResponseEntity.status(200).body("Admin registered successfully");
    }
}
