package com.Training_System.controller.impl;

<<<<<<< HEAD
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Training_System.model.Certificate;
import com.Training_System.service.impl.CertificateService;

@RestController
@RequestMapping("/api/certificates")
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
=======

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
>>>>>>> branch 'master' of https://github.com/sadoma2000/TrainingSystem.git
