package com.Training_System.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Training_System.model.Certificate;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Long> {

    Certificate findCertificateById(long id);

    List<Certificate> findByStudentId(Long studentId);

}
