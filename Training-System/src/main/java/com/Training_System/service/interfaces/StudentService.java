package com.Training_System.models.service;

import com.Training_System.models.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {

    List<Student> getAllStudents();
    Student getStudentById(Long id);
    String addStudent(Student student);
    String updateStudent(Student student);
    void deleteStudent(Long id);

}
