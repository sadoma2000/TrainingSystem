package com.Training_System.service.impl;

import com.Training_System.model.Instructor;
import com.Training_System.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.Training_System.model.Course;
import com.Training_System.repository.CourseRepository;
import com.Training_System.service.interfaces.ICourseService;

import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@Service
@RequiredArgsConstructor
public class CourseService implements ICourseService {

    @Autowired
    CourseRepository courseRepository;

    private final InstructorRepository instructorRepository;


    @Override
    public void saveCourse(Long instructorId, Course course) {
        Course newCourse = new Course();
        newCourse.setTopic(course.getTopic());
        newCourse.setStartDate(course.getStartDate());
        newCourse.setEndDate(course.getEndDate());
        newCourse.setInstructor(instructorRepository.findInstructorById(instructorId));
        newCourse.setNumberOfLessons(course.getNumberOfLessons());
        newCourse.setCourseLevel(course.getCourseLevel());
        newCourse.setDescription(course.getDescription());

        courseRepository.save(course);

    }

    @Override
    public void updateCourse(Timestamp Start_date, Timestamp End_date, Long id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if (courseOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course " + id + " not found");

        Course c = courseOptional.get();
        c.setStartDate(Start_date);
        c.setEndDate(End_date);
        courseRepository.save(c);

    }

    @Override
    public void deleteCourse(Long id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if (courseOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course " + id + " not found");
        courseRepository.deleteById(id);

    }
}
