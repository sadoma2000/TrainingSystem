package com.Training_System.service.impl;

import com.Training_System.Api.ApiException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.Training_System.model.Review;
import com.Training_System.repository.ReviewRepository;
import com.Training_System.service.interfaces.IReviewService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@Service
public class ReviewService implements IReviewService {

	@Autowired
	ReviewRepository reviewRepository;

	@Override
	public List<Review> getAllReviews() {
		return reviewRepository.findAll();
	}

	@Override
	public Review getReviewById(Long id) {
		return reviewRepository.findById(id)
				.orElseThrow(() -> new ApiException("Review not found with id " + id));
	}

	@Override
	public void saveReview(Review review) {
		reviewRepository.save(review);
	}

	@Override
	public void updateReview(String reviewText, Long id) {
		Optional<Review> reviewOptional = reviewRepository.findById(id);
		if (reviewOptional.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Review " + id + " not found");

		Review review = reviewOptional.get();
		review.setReviewText(reviewText);
		reviewRepository.save(review);
	}

	@Override
	public void deleteReview(Long id) {
		Optional<Review> reviewOptional = reviewRepository.findById(id);
		if (reviewOptional.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Review " + id + " not found");
		reviewRepository.deleteById(id);
	}

	@Override
	public List<Review> getReviewsByCourseId(Long courseId) {
		return reviewRepository.findByCourseId(courseId);
	}

	@Override
	public List<Review> getReviewsByStudentId(Long studentId) {
		return reviewRepository.findByStudentId(studentId);
	}
}