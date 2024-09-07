package com.Training_System.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Training_System.model.Review;
import com.Training_System.service.interfaces.ReviewService;

import java.util.List;

@RestController
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
        return reviewService.addReview(review);
    }

    @PutMapping("/updateReview")
    public String updateReview(@RequestBody Review review) {
        return reviewService.updateReview(review);
    }

    @DeleteMapping("/deleteReview/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }
}
