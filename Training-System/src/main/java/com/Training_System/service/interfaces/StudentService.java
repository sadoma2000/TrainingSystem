package com.Training_System.service.interfaces;

import java.util.List;

import com.Training_System.model.Student;

public interface StudentService {

	List<Student> getAllStudents();

	Student getStudentById(Long id);

	String addStudent(Student student);

	String updateStudent(Student student);

	void deleteStudent(Long id);

}
