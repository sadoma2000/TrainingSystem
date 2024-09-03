package com.Training_System.service.interfaces;

import com.Training_System.model.Instructor;

public interface IInstructorService {
	void saveInstructor(Instructor instructor);

	void updateInstructor(String Language_spoken, Long id);

	void deleteInstructor(Long id);


}
