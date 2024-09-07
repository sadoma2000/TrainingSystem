package com.Training_System.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Training_System.model.Enrollment;
import com.Training_System.repository.EnrollmentRepository;
import com.Training_System.service.interfaces.IEnrollmentService;

@Service
public class EnrollmentService implements IEnrollmentService{

	@Autowired
	private EnrollmentRepository enrollmentRepository;

	@Override
	public List<Enrollment> getAllEnrollments() {
		return enrollmentRepository.findAll();
	}

	@Override
	public Enrollment getEnrollmentById(Long id) {
		return enrollmentRepository.findById(id).orElse(null);
	}

	@Override
	public Enrollment createEnrollment(Enrollment enrollment) {
		return enrollmentRepository.save(enrollment);
	}

	@Override
	public Enrollment updateEnrollment(Long id, Enrollment enrollment) {
		Optional<Enrollment> existingEnrollment = enrollmentRepository.findById(id);
		if (existingEnrollment.isPresent()) {
			Enrollment updatedEnrollment = existingEnrollment.get();
			updatedEnrollment.setState(enrollment.getState());
			updatedEnrollment.setStudent(enrollment.getStudent());
			updatedEnrollment.setCourse(enrollment.getCourse());
			return enrollmentRepository.save(updatedEnrollment);
		}
		return null;
	}

	@Override
	public void deleteEnrollment(Long id) {
		enrollmentRepository.deleteById(id);
	}


}
