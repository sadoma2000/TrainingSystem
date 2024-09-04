package com.Training_System.models.service;


import com.Training_System.models.entity.Student;
import com.Training_System.models.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id " + id));
    }

    @Override
    public String addStudent(Student student) {
        Student exist = studentRepository.findById(student.getId()).orElse(null);
        if (exist == null) {
            studentRepository.save(student);
            return "Student Saved Successfully.";
        } else {
            throw new StudentAlreadyExistsException("Student Already Exists!");
        }
    }

    @Override
    public String updateStudent(Student student) {
        Student exist = studentRepository.findById(student.getId()).orElse(null);
        if (exist == null) {
            throw new NoSuchStudentException("No Student Exists!");
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



