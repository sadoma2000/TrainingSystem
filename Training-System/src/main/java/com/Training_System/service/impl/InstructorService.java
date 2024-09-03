package com.Training_System.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.Training_System.model.Instructor;
import com.Training_System.repository.InstructorRepository;
import com.Training_System.service.interfaces.IInstructorService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@Service
public class InstructorService implements IInstructorService {

	@Autowired
	InstructorRepository instructorRepository;

	@Override
	public void saveInstructor(Instructor instructor) {
		Instructor newInstructor = new Instructor();
		newInstructor.setFirst_name(instructor.getFirst_name());
		newInstructor.setLast_name(instructor.getLast_name());
		newInstructor.setDepartment(instructor.getDepartment());
		newInstructor.setLanguage_spoken(instructor.getLanguage_spoken());
		newInstructor.setGender(instructor.getGender());

		instructorRepository.save(newInstructor);
	}

	@Override
	public void updateInstructor(String Language_spoken, Long id) {
		Optional<Instructor> instructorOptional = instructorRepository.findById(id);
		if (instructorOptional.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Instructor " + id + " not found");

		Instructor ins = instructorOptional.get();
		ins.setLanguage_spoken(Language_spoken);
		instructorRepository.save(ins);
	}

	@Override
	public void deleteInstructor(Long id) {
		Optional<Instructor> instructorOptional = instructorRepository.findById(id);
		if (instructorOptional.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Instructor " + id + " not found");
		instructorRepository.deleteById(id);
	}
}
