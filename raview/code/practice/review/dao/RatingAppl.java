package practice.review.dao;

import practice.review.model.Review;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

public class RatingAppl {
    public static void main(String[] args) {
        RatingImpl rating = new RatingImpl();
        LocalDateTime data;

        Random random = new Random();
        rating.add(new Review(1, 5, "Author1", "Product1", "Good product", randomLikes(), LocalDateTime.now()));
        rating.add(new Review(2, 1, "Author2", "Product2", "Good product", randomLikes(), LocalDateTime.now()));
        rating.add(new Review(3, 3, "Author3", "Product3", "Good product", randomLikes(), LocalDateTime.now()));
        rating.add(new Review(4, 1, "Author4", "Product4", "Good product", randomLikes(), LocalDateTime.now()));
        rating.add(new Review(5, 5, "Author5", "Product1", "Good product", randomLikes(), LocalDateTime.now()));
        rating.add(new Review(6, 5, "Author6", "Product2", "Good product", randomLikes(), LocalDateTime.now()));
        rating.add(new Review(7, 4, "Author7", "Product3", "Good product", randomLikes(), LocalDateTime.now()));
        rating.add(new Review(8, 3, "Author8", "Product1", "Good product", randomLikes(), LocalDateTime.now()));
        rating.add(new Review(9, 3, "Author9", "Product1", "Good product", randomLikes(), LocalDateTime.now()));
        rating.add(new Review(10, 1, "Author10", "Product2", "Good product", randomLikes(), LocalDateTime.now()));

        System.out.printf("Avg Rating for Product1: %.2f", rating.getAvgRatingByProduct("Product1"));
        System.out.println();
        System.out.println("Reviews with max likes: " + rating.getReviewsMaxLikes());
        System.out.println("Review of product 4: " + rating.getReviewsByProduct("Product4"));
        System.out.println("Review ");
        System.out.println("------------------------------");

        List<String> productsSortedByRating= rating.getProductsSortedByRating();
        System.out.println("Products sorted by rating: " + productsSortedByRating);
        System.out.println("------------------------------");
        List<String>productSortedByReviews = rating.getProductSortedByReviews();
        System.out.println("Product sorted by reviews: " + productSortedByReviews);
        System.out.println("------------------------------");
        List<String>authorsSortedByLikes = rating.getAuthorsSortedByLikes();
        System.out.println("Authors sorted by likes : " + authorsSortedByLikes);

    }

    private static int randomLikes() {
        return new Random().nextInt(41) + 10;
    }
    private static void printReviews(List<Review>reviews){
        for (Review r:reviews) {
            System.out.println(r);

        }
    }
}
