package com.Training_System.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.Training_System.model.Certificate;
import com.Training_System.repository.CertificateRepository;
import com.Training_System.service.interfaces.ICertificateService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@Service
public class CertificateService implements ICertificateService {

    @Autowired
    CertificateRepository certificateRepository;

    @Override
    public void saveCertificate(Certificate certificate) {
        Certificate newCertificate = new Certificate();
        newCertificate.setStudent_id(certificate.getStudent_id());
        newCertificate.setCourse_id(certificate.getCourse_id());
        newCertificate.setIssued_date(certificate.getIssued_date());
        newCertificate.setCertificate_title(certificate.getCertificate_title());

        certificateRepository.save(newCertificate);
    }

    @Override
    public void updateCertificate(String certificateTitle, Long id) {
        Optional<Certificate> certificateOptional = certificateRepository.findById(id);
        if (certificateOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Certificate " + id + " not found");

        Certificate c = certificateOptional.get();
        c.setCertificate_title(certificateTitle);
        certificateRepository.save(c);
    }

    @Override
    public void deleteCertificate(Long id) {
        Optional<Certificate> certificateOptional = certificateRepository.findById(id);
        if (certificateOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Certificate " + id + " not found");
        certificateRepository.deleteById(id);
    }
}
