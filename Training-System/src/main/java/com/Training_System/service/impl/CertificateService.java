package com.Training_System.service.impl;

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
	public String addCertificate(Certificate certificate) {
		certificateRepository.save(certificate);
		return "Certificate added successfully";
	}

	@Override
	public String updateCertificate(Certificate certificate) {
		Optional<Certificate> existingCertificateOptional = certificateRepository.findById(certificate.getId());
		if (existingCertificateOptional.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Certificate " + certificate.getId() + " not found");
		}

		Certificate existingCertificate = existingCertificateOptional.get();
		existingCertificate.setStudentId(certificate.getStudentId());
		existingCertificate.setCourseId(certificate.getCourseId());
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