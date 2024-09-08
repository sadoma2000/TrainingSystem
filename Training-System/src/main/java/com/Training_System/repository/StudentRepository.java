package com.Training_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Training_System.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findStudentById(long id);
}
