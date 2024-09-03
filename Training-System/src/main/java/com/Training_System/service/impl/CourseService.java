package com.Training_System.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.Training_System.model.Course;
import com.Training_System.repository.CourseRepository;
import com.Training_System.service.interfaces.ICourseService;

import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@Service
public class CourseService implements ICourseService {

	@Autowired
	CourseRepository courseRepository;

	@Override
	public void saveCourse(Course course) {
		Course newCourse = new Course();
		newCourse.setTopic(course.getTopic());
		newCourse.setStart_date(course.getStart_date());
		newCourse.setEnd_date(course.getEnd_date());
		newCourse.setInstructor_id(course.getInstructor_id());
		newCourse.setPasing_grade(course.getPasing_grade());
		newCourse.setCourse_level(course.getCourse_level());
		newCourse.setDescription(course.getDescription());

		courseRepository.save(newCourse);

	}

	@Override
	public void updateCourse(Timestamp Start_date, Timestamp End_date, Long id) {
		Optional<Course> courseOptional = courseRepository.findById(id);
		if (courseOptional.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course " + id + " not found");

		Course c = courseOptional.get();
		c.setStart_date(Start_date);
		c.setEnd_date(End_date);
		courseRepository.save(c);

	}

	@Override
	public void deleteCourse(Long id) {
		Optional<Course> courseOptional = courseRepository.findById(id);
		if (courseOptional.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course " + id + " not found");
		courseRepository.deleteById(id);

	}
}
