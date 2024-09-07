package com.Training_System.service.interfaces;

import com.Training_System.model.Review;

public interface IReviewService {

	void saveReview(Review review);

    void updateReview(String reviewText, Long id);

    void deleteReview(Long id);
}
