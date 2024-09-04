package com.Training_System.models.service;

import com.Training_System.models.entity.Lesson;

import java.util.List;

public interface LessonService {

    List<Lesson> getAllLessons();
    List<Lesson> getLessonsByCourseId(Long courseId);
    Lesson getLessonById(Long id);
    String addLesson(Lesson lesson);
    String updateLesson(Lesson lesson);
    void deleteLesson(Long id);
}
