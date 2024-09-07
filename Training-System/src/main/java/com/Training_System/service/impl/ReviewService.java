package com.Training_System.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.Training_System.model.Review;
import com.Training_System.repository.ReviewRepository;
import com.Training_System.service.interfaces.IReviewService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@Service
public class ReviewService implements IReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public void saveReview(Review review) {
        Review newReview = new Review();
        newReview.setStudentId(review.getStudentId());
        newReview.setCourseId(review.getCourseId());
        newReview.setReviewText(review.getReviewText());
        newReview.setRating(review.getRating());

        reviewRepository.save(newReview);
    }

    @Override
    public void updateReview(String reviewText, Long id) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if (reviewOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Review " + id + " not found");

        Review r = reviewOptional.get();
        r.setReviewText(reviewText);
        reviewRepository.save(r);
    }

    @Override
    public void deleteReview(Long id) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if (reviewOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Review " + id + " not found");
        reviewRepository.deleteById(id);
    }
