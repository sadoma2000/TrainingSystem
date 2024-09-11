package com.Training_System.service.interfaces;


import java.util.List;

import com.Training_System.model.Lesson;

public interface ILessonService {

    List<Lesson> getAllLessons();

    List<Lesson> getLessonsByCourseId(Long courseId);

    Lesson getLessonById(Long id);

    String updateLesson(Lesson lesson);

    void deleteLesson(Long id);
}
