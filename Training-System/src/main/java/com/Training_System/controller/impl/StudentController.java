package com.Training_System.models.controller;

import com.Training_System.models.entity.Student;
import com.Training_System.models.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService StudentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return StudentService.getAllStudents();
    }

    @GetMapping("/getStudentById/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return StudentService.getStudentById(id);
    }

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student) {

        return StudentService.addStudent(student);
    }

    @PutMapping("/updateStudent")
    public String updateStudent(@RequestBody Student student) {

        return StudentService.updateStudent(student);
    }


    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable Long id) {
        StudentService.deleteStudent(id);
    }
}