package com.Training_System.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Training_System.model.Review;
import com.Training_System.service.impl.ReviewService;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@GetMapping("/getAllReviews")
	public List<Review> getAllReviews() {
		return reviewService.getAllReviews();
	}

	@GetMapping("/getReviewsByCourseId/{courseId}")
	public List<Review> getReviewsByCourseId(@PathVariable Long courseId) {
		return reviewService.getReviewsByCourseId(courseId);
	}

	@GetMapping("/getReviewsByStudentId/{studentId}")
	public List<Review> getReviewsByStudentId(@PathVariable Long studentId) {
		return reviewService.getReviewsByStudentId(studentId);
	}

	@GetMapping("/getReviewById/{id}")
	public Review getReviewById(@PathVariable Long id) {
		return reviewService.getReviewById(id);
	}

	@PostMapping("/addReview")
	public String addReview(@RequestBody Review review) {
		reviewService.saveReview(review);
		return "Review added successfully";
	}

	@PutMapping("/updateReview/{id}")
	public String updateReview(@RequestBody String reviewText, @PathVariable Long id) {
		reviewService.updateReview(reviewText, id);
		return "Review updated successfully";
	}

	@DeleteMapping("/deleteReview/{id}")
	public String deleteReview(@PathVariable Long id) {
		reviewService.deleteReview(id);
		return "Review deleted successfully";
	}
}

