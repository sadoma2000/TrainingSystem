package com.Training_System.controller.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Training_System.model.Lesson;
import com.Training_System.service.interfaces.LessonService;

import java.util.List;

@RestController
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    @GetMapping("/getAllCertificates")
    public List<Certificate> getAllCertificates() {
        return certificateService.getAllCertificates();
    }

    @GetMapping("/getCertificatesByStudentId/{studentId}")
    public List<Certificate> getCertificatesByStudentId(@PathVariable Long studentId) {
        return certificateService.getCertificatesByStudentId(studentId);
    }

    @GetMapping("/getCertificateById/{id}")
    public Certificate getCertificateById(@PathVariable Long id) {
        return certificateService.getCertificateById(id);
    }

    @PostMapping("/addCertificate")
    public String addCertificate(@RequestBody Certificate certificate) {
        return certificateService.addCertificate(certificate);
    }

    @PutMapping("/updateCertificate")
    public String updateCertificate(@RequestBody Certificate certificate) {
        return certificateService.updateCertificate(certificate);
    }

    @DeleteMapping("/deleteCertificate/{id}")
    public void deleteCertificate(@PathVariable Long id) {
        certificateService.deleteCertificate(id);
    }
}