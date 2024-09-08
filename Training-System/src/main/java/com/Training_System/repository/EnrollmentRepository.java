package com.Training_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Training_System.model.Enrollment;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long>{
    Enrollment findEnrollmentById(long id);

}
