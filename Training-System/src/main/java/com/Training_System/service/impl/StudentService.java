package com.Training_System.service.impl;


import com.Training_System.Api.ApiException;
import com.Training_System.model.AppUser;
import com.Training_System.model.DTO.StudentDTO;
import com.Training_System.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Training_System.model.Student;
import com.Training_System.repository.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {


    @Autowired
    private StudentRepository studentRepository;

    private final AuthRepository authRepository;

    //@Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    //@Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ApiException("Student not found with id " + id));
    }

    public void registerStudent(StudentDTO studentDTO) {
        String hash = new BCryptPasswordEncoder().encode(studentDTO.getPassword());

        AppUser user = new AppUser();
        user.setUsername(studentDTO.getUsername());
        user.setPassword(hash);
        user.setFirstName(studentDTO.getFirstName());
        user.setLastName(studentDTO.getLastName());
        user.setGender(studentDTO.getGender());
        user.setRole("STUDENT");
        authRepository.save(user);

        Student student = new Student();
        student.setMajor(studentDTO.getMajor());
        student.setUser(user);
        studentRepository.save(student);
    }

    //@Override
    public String updateStudent(Student student) {
        Student exist = studentRepository.findById(student.getId()).orElse(null);
        if (exist == null) {
            throw new ApiException("No Student Exists!");
        } else {
            exist.setMajor(student.getMajor());

            studentRepository.save(exist);
            return "Student Updated Successfully!";
        }
    }

    //@Override
    public void deleteStudent(Long id) {
        Student student = getStudentById(id);
        studentRepository.delete(student);
    }
}



