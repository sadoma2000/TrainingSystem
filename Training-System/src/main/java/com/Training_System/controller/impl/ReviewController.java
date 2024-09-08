package com.Training_System.controller.impl;

import com.Training_System.model.Enrollment;
import com.Training_System.model.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

	//  ****************************************************  GET  ****************************************************
	@GetMapping("/get-all")
	public ResponseEntity getAllReviews() {
		return ResponseEntity.status(200).body(reviewService.getAllReviews());
	}

	@GetMapping("/get-by-Review/{courseId}")
	public ResponseEntity getReviewsByCourseId(@PathVariable Long courseId) {
		return ResponseEntity.status(200).body(reviewService.getReviewsByCourseId(courseId));
	}

	@GetMapping("/get-by-Review/{studentId}")
	public ResponseEntity getReviewsByStudentId(@PathVariable Long studentId) {
		return ResponseEntity.status(200).body(reviewService.getReviewsByStudentId(studentId));
	}

	@GetMapping("/get-by-id/{id}")
	public ResponseEntity getReviewById(@PathVariable Long id) {
		return ResponseEntity.status(200).body(reviewService.getReviewById(id));
	}

	//  ***************************************************  POST  ****************************************************
	@PostMapping("/add")
	public ResponseEntity addReview(@RequestBody Review review) {
		reviewService.saveReview(review);
		return ResponseEntity.status(201).body("Review added successfully");
	}

	//  ****************************************************  PUT  ****************************************************
	@PutMapping("/update/{id}")
	public ResponseEntity updateReview( @RequestBody String reviewText,@PathVariable Long id) {
		reviewService.updateReview(reviewText,id);
		return ResponseEntity.status(201).body("Review updated successfully");
	}

	//  **************************************************  DELETE  ***************************************************
	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteReview(@PathVariable Long id) {
		reviewService.deleteReview(id);
		return ResponseEntity.status(201).body("Review deleted successfully");
	}

}

