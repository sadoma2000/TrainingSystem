package com.Training_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Training_System.model.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    Instructor findInstructorById(long id);
}
