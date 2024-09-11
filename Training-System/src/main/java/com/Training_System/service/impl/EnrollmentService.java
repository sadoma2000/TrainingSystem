package com.Training_System.service.impl;

import java.util.List;
import java.util.Optional;

import com.Training_System.Api.ApiException;
import com.Training_System.model.Course;
import com.Training_System.model.Progress;
import com.Training_System.repository.CourseRepository;
import com.Training_System.repository.ProgressRepository;
import com.Training_System.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Training_System.model.Enrollment;
import com.Training_System.repository.EnrollmentRepository;
import com.Training_System.service.interfaces.IEnrollmentService;

@Service
@RequiredArgsConstructor
public class EnrollmentService implements IEnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    private final CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ProgressRepository progressRepository;

    @Override
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    @Override
    public Enrollment getEnrollmentById(Long id) {
        return enrollmentRepository.findById(id).orElse(null);
    }

    //@Override
    public Enrollment createEnrollment(Long studentId, Long courseId) {
        Course course = courseRepository.findCourseById(courseId);
        if (course == null) {
            throw new ApiException("Course not found");
        }
        Enrollment newEnrollment = new Enrollment();
        newEnrollment.setCourse(course);
        newEnrollment.setStudent(studentRepository.findStudentById(studentId));
        return enrollmentRepository.save(newEnrollment);
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

    public void acceptEnrollment(Long instructorId, Long enrollmentId) { //edit to accommodate with relations
        Enrollment enrollment = enrollmentRepository.findEnrollmentById(enrollmentId);
        Course course = courseRepository.findCourseById(enrollment.getCourse().getId());
        if (!course.getInstructor().getId().equals(instructorId)) {
            throw new ApiException("Course is not owned by the instructor");
        }
        if (!enrollment.getState().equalsIgnoreCase("pending")) {
            throw new ApiException("Only pending enrollments can be accepted");
        }
        enrollment.setState("Accepted");
        enrollmentRepository.save(enrollment);

        //create progress automatically when accepted
        Progress progress = new Progress();

        progress.setStudent(enrollment.getStudent());
        progress.setCourse(enrollment.getCourse());

        progress.setCompletedLessons(0);
        progress.setRequiredLessons(course.getNumberOfLessons());

        progressRepository.save(progress);
    }

    public void rejectEnrollment(Long instructorId, Long enrollmentId) { //add controller
        Enrollment enrollment = enrollmentRepository.findEnrollmentById(enrollmentId);
        Course course = courseRepository.findCourseById(enrollment.getCourse().getId());

        if (!course.getInstructor().getId().equals(instructorId)) {
            throw new ApiException("Course is not owned by the instructor");
        }
        if (!enrollment.getState().equalsIgnoreCase("pending")) {
            throw new ApiException("Only pending enrollments can be rejected");
        }
        enrollment.setState("Rejected");
        enrollmentRepository.save(enrollment);
    }

    @Override
    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteById(id);
    }


}
