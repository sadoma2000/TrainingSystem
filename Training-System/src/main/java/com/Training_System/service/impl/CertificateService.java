package com.Training_System.service.impl;

import com.Training_System.model.Student;
import com.Training_System.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.Training_System.model.Certificate;
import com.Training_System.repository.CertificateRepository;
import com.Training_System.service.interfaces.ICertificateService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@Service
public class CertificateService implements ICertificateService {

    @Autowired
    private CertificateRepository certificateRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Certificate> getAllCertificates() {
        return certificateRepository.findAll();
    }

    @Override
    public List<Certificate> getCertificatesByStudentId(Long studentId) {
        return certificateRepository.findByStudentId(studentId);
    }

    @Override
    public Certificate getCertificateById(Long id) {
        return certificateRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Certificate " + id + " not found"));
    }

    @Override
    public String addCertificate(Certificate certificate, Long studentId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (studentOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student " + studentId + " not found");
        }
        certificate.setStudent(studentOptional.get());
        certificateRepository.save(certificate);
        return "Certificate added successfully";
    }

    @Override
    public String updateCertificate(Certificate certificate, Long id) {
        Optional<Certificate> existingCertificateOptional = certificateRepository.findById(id);
        if (existingCertificateOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Certificate " + id + " not found");
        }

        Certificate existingCertificate = existingCertificateOptional.get();
        existingCertificate.setStudent(certificate.getStudent());
        existingCertificate.setCourse(certificate.getCourse());
        existingCertificate.setIssuedDate(certificate.getIssuedDate());
        existingCertificate.setCertificateTitle(certificate.getCertificateTitle());

        certificateRepository.save(existingCertificate);
        return "Certificate updated successfully";
    }

    @Override
    public void deleteCertificate(Long id) {
        Optional<Certificate> certificateOptional = certificateRepository.findById(id);
        if (certificateOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Certificate " + id + " not found");
        }
        certificateRepository.deleteById(id);
    }
}