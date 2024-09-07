package com.Training_System.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Training_System.model.Review;


@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{

	List<Review> findByCourseId(Long courseId);

	List<Review> findByStudentId(Long studentId);
}
