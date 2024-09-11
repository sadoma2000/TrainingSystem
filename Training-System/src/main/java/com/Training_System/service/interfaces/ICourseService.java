package com.Training_System.service.interfaces;

import java.sql.Timestamp;

import com.Training_System.model.Course;

public interface ICourseService {
    void saveCourse(Long instructorId, Course course);

    void updateCourse(Timestamp Start_date, Timestamp End_date, Long id);

    void deleteCourse(Long id);


}
