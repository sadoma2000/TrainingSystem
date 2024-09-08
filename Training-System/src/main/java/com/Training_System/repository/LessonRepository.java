package com.Training_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Training_System.model.Lesson;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
	Lesson findLessonById(long id);
	List<Lesson> findByCourseId(Long courseId);
}
