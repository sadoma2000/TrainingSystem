package com.Training_System.service.interfaces;

import java.util.List;

import com.Training_System.model.Review;

public interface IReviewService {

	List<Review> getAllReviews();

	Review getReviewById(Long id);

	void saveReview(Review review);

	void updateReview(String reviewText, Long id);

	void deleteReview(Long id);

	List<Review> getReviewsByCourseId(Long courseId);

	List<Review> getReviewsByStudentId(Long studentId);
}
