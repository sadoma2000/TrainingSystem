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

import com.Training_System.controller.interfaces.IInstructorController;
import com.Training_System.model.Instructor;
import com.Training_System.repository.InstructorRepository;
import com.Training_System.service.interfaces.IInstructorService;

@RestController
@RequestMapping("/api")
public class InstructorController implements IInstructorController{

	@Autowired
	InstructorRepository instructorRepository;

	@Autowired
	IInstructorService instructorService;

	//  ****************************************************  GET  ****************************************************

	@GetMapping("/AllInstructors")
	public List<Instructor> getAllInstructors() {
		return instructorRepository.findAll();
	}

	//  ***************************************************  POST  ****************************************************

	@PostMapping("/AddInstructor")
	//@ResponseStatus(HttpStatus.CREATED)
	public void saveInstructor(@RequestBody Instructor instructor) {
		instructorService.saveInstructor(instructor);
	}

	//  ****************************************************  PUT  ****************************************************

	@PutMapping("/Instructor/Update/{id}")
	//@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateInstructor(@RequestBody Instructor instructor, @PathVariable Long id) {
		instructorService.updateInstructor(instructor.getLanguage_spoken(), id);
	}
	//  **************************************************  DELETE  ***************************************************

	@DeleteMapping("/Instructor/{id}")
	// @ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteExercise(@PathVariable Long id) {
		instructorService.deleteInstructor(id);
	}
}
