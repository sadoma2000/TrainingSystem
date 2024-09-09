package com.Training_System.service.impl;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.Training_System.Api.ApiException;
import com.Training_System.model.*;
import com.Training_System.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.Training_System.service.interfaces.IProgressService;

@Service
public class ProgressService implements IProgressService {

	@Autowired
	private ProgressRepository progressRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private LessonRepository lessonRepository;
    @Autowired
    private CertificateRepository certificateRepository;

	@Override
	public Progress getProgressById(Long id) {
		return progressRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Progress " + id + " not found"));
	}

	@Override
	public List<Progress> getAllProgress() {
		return progressRepository.findAll();
	}

	@Override
	public List<Progress> getProgressByStudentId(Long studentId) {
		return progressRepository.findByStudentId(studentId);
	}

	@Override
	public String addProgress(Progress progress) { //redundant by acceptEnrollment
		Progress newProgress = new Progress();
		newProgress.setStudentId(progress.getStudentId());
		newProgress.setCourseId(progress.getCourseId());
		newProgress.setCompletedLessons(progress.getCompletedLessons());
		newProgress.setRequiredLessons(progress.getRequiredLessons());

		progressRepository.save(newProgress);
		return "Progress added successfully";
	}

	public void watchLesson(Long studentId, Long courseId, Long lessonId) {
		Student student = studentRepository.findStudentById(studentId);
		Course course = courseRepository.findCourseById(courseId);
		Lesson lesson = lessonRepository.findLessonById(lessonId);

		if (lesson == null) {
			throw new ApiException("Lesson not found");
		}
		if (course == null) {
			throw new ApiException("Course not found");
		}
		if (lesson.getCourse().getId() != course.getId()) {
			throw new ApiException("Lesson does not belong to this course");
		}

		Progress progress = progressRepository.findProgressByStudentIdAndCourseId(studentId, courseId);
		if (progress == null) {
			throw new ApiException("Student is not enrolled to this course");
		}

		progress.setCompletedLessons(progress.getCompletedLessons() + 1); //replace with a list? so no duplicates.
		progressRepository.save(progress);

		//Issue certificate
		if (progress.getCompletedLessons() >= progress.getRequiredLessons()) {
			Certificate certificate = new Certificate();
			certificate.setStudentId(studentId); //EDIT
			certificate.setCourseId(courseId); //EDIT
			certificate.setCertificateTitle("Completion of "+course.getTopic());
			certificate.setIssuedDate(LocalDate.now());
			certificateRepository.save(certificate);
		}
	}

	@Override
	public String updateProgress(Progress progress) {
		Optional<Progress> progressOptional = progressRepository.findById(progress.getId());
		if (progressOptional.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Progress " + progress.getId() + " not found");
		}

		Progress existingProgress = progressOptional.get();
		existingProgress.setCompletedLessons(progress.getCompletedLessons());
		existingProgress.setRequiredLessons(progress.getRequiredLessons());

		progressRepository.save(existingProgress);
		return "Progress updated successfully";
	}

	@Override
	public void deleteProgress(Long id) {
		Optional<Progress> progressOptional = progressRepository.findById(id);
		if (progressOptional.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Progress " + id + " not found");
		}
		progressRepository.deleteById(id);
	}
}