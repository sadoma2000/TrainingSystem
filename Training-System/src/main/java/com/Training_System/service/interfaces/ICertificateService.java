package com.Training_System.service.interfaces;

import java.util.List;

import com.Training_System.model.Certificate;

public interface ICertificateService {

    List<Certificate> getAllCertificates();

    List<Certificate> getCertificatesByStudentId(Long studentId);

    Certificate getCertificateById(Long id);

    String addCertificate(Certificate certificate, Long studentId);

    String updateCertificate(Certificate certificate, Long id); // Update the method signature here

    void deleteCertificate(Long id);
}
