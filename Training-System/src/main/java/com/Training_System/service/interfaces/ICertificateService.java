package com.Training_System.service.interfaces;

import com.Training_System.model.Certificate;

public interface ICertificateService {
	void saveCertificate(Certificate certificate);

	void updateCertificate(String certificateTitle, Long id);

	void deleteCertificate(Long id);
}
