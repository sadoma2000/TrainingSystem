package com.Training_System.service.impl;



import com.Training_System.Api.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Training_System.model.Student;
import com.Training_System.repository.StudentRepository;
import com.Training_System.service.interfaces.StudentService;

import java.util.List;

@Service
public class StudentServicempl implements StudentService {


	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id)
				.orElseThrow(() -> new ApiException("Student not found with id " + id));
	}

	@Override
	public String addStudent(Student student) {
		Student exist = studentRepository.findById(student.getId()).orElse(null);
		if (exist == null) {
			studentRepository.save(student);
			return "Student Saved Successfully.";
		} else {
			throw new ApiException("Student Already Exists!");
		}
	}

	@Override
	public String updateStudent(Student student) {
		Student exist = studentRepository.findById(student.getId()).orElse(null);
		if (exist == null) {
			throw new ApiException("No Student Exists!");
		} else {
			exist.setFirst_name(student.getFirst_name());
			exist.setLast_name(student.getLast_name());
			exist.setEmail(student.getEmail());
			exist.setMajor(student.getMajor());
			exist.setGender(student.getGender());
			studentRepository.save(exist);
			return "Student Updated Successfully!";
		}
	}

	@Override
	public void deleteStudent(Long id) {
		Student student = getStudentById(id);
		studentRepository.delete(student);
	}
}



