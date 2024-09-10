package com.Training_System.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

	//  ****************************************************  GET  ****************************************************
	@GetMapping("/get-all")
	public ResponseEntity getAllCertificates() {
		return ResponseEntity.status(200).body(certificateService.getAllCertificates());
	}

	@GetMapping("/get-by-student/{studentId}")
	public ResponseEntity getCertificatesByStudentId(@PathVariable Long studentId) {
		return ResponseEntity.status(200).body(certificateService.getCertificatesByStudentId(studentId));
	}

	@GetMapping("/get-by-id/{id}")
	public ResponseEntity getCertificateById(@PathVariable Long id) {
		return ResponseEntity.status(200).body(certificateService.getCertificateById(id));
	}

	//  ***************************************************  POST  ****************************************************
	
	@PostMapping("/add/{studentId}")
       //@ResponseStatus(HttpStatus.CREATED)
        public ResponseEntity addCertificate(@PathVariable Long studentId, @RequestBody Certificate certificate) {
              certificateService.addCertificate(studentId, certificate);
              return ResponseEntity.status(201).body("Certificate added successfully");
              }

	//  ****************************************************  PUT  ****************************************************
	@PutMapping("/update/{id}")
	public ResponseEntity updateCertificate(@RequestBody Certificate certificate, @PathVariable Long id) {
                certificateService.updateCertificate(certificate, id); 
		return ResponseEntity.status(201).body("Certificate updated successfully");
	}

	//  **************************************************  DELETE  ***************************************************
	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteCertificate(@PathVariable Long id) {
		certificateService.deleteCertificate(id);
		return ResponseEntity.status(201).body("Certificate deleted successfully");
	}
}
