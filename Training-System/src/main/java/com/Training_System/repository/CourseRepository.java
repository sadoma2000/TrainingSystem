package com.Training_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Training_System.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
    Course findCourseById(long id);
}
