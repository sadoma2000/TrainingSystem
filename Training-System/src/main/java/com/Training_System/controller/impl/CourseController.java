package com.Training_System.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Training_System.controller.interfaces.ICourseController;
import com.Training_System.model.Course;
import com.Training_System.repository.CourseRepository;
import com.Training_System.service.interfaces.ICourseService;

@RestController
@RequestMapping("/api")
public class CourseController implements ICourseController{

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	ICourseService courseService;

	//  ****************************************************  GET  ****************************************************

	@Override
	@GetMapping("/AllCourses")
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	//  ***************************************************  POST  ****************************************************

	@PostMapping("/AddCourse")
	//@ResponseStatus(HttpStatus.CREATED)
	public void saveCourse(@RequestBody Course course) {
		courseService.saveCourse(course);
	}

	//  ****************************************************  PUT  ****************************************************

	@PutMapping("/Course/Update/{id}")
	//@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateCourse(@RequestBody Course updatedCourse, @PathVariable Long id) {
		courseService.updateCourse(updatedCourse.getStartDate(),updatedCourse.getEndDate(), id);
	}
	//  **************************************************  DELETE  ***************************************************

	@DeleteMapping("/Course/{id}")
	// @ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCourse(@PathVariable Long id) {
		courseService.deleteCourse(id);
	}

}
