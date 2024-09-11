package com.Training_System.service.interfaces;

import java.util.List;

import com.Training_System.model.Enrollment;

public interface IEnrollmentService {

    List<Enrollment> getAllEnrollments();

    Enrollment getEnrollmentById(Long id);


    Enrollment updateEnrollment(Long id, Enrollment enrollment);

    void deleteEnrollment(Long id);
}
