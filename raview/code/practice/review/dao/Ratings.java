package practice.review.dao;

import practice.review.model.Review;

public interface Ratings {
    boolean add(Review review);
    boolean remove(long id);
    boolean update(long id, int newRating);
    Iterable<Review> getReviewsByProduct(String product);
    Iterable<Review> getReviewsByAuthor(String author);
    double getAvgRatingByProduct(String product);
    Iterable<Review> getReviewsMaxLikes();
}
