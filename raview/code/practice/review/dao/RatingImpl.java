package practice.review.dao;

import practice.review.model.Review;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

class RatingImpl implements Ratings {
    private List<Review>reviews;

    public RatingImpl(){
        this.reviews = new ArrayList<>();
    }

    @Override
    public boolean add(Review review) {
        boolean authorAlreadyReviewed = reviews.stream()
                .anyMatch(r->r.getProduct().equals(review.getProduct()) && r.getAuthor().equals(review.getAuthor()));
        if (!authorAlreadyReviewed){
            reviews.add(review);
            return true;
        } return false;
    }

    @Override
    public boolean remove(long id) {
        return reviews.removeIf(r->r.getId()==id);
    }

    @Override
    public boolean update(long id, int newRating) {
        for (Review review : reviews) {
            if (review.getId() == id) {
                review.setRating(newRating);
                return true;
            }
        }return false;
    }

    @Override
    public Iterable<Review> getReviewsByProduct(String product) {
        return reviews.stream()
                .filter(r->r.getProduct().equals(product))
                        .toList();
    }

    @Override
    public Iterable<Review> getReviewsByAuthor(String author) {
        return reviews.stream()
                .filter(r->r.getAuthor().equals(author))
                .toList();
    }

    @Override
    public double getAvgRatingByProduct(String product) {
        OptionalDouble avgRaring = reviews.stream()
                .filter(r->r.getProduct().equals(product))
                .mapToInt(Review::getRating)
                .average();
        return avgRaring.orElse(0);
    }

    @Override
    public Iterable<Review> getReviewsMaxLikes() {
        int maxLikes = reviews.stream()
                .mapToInt(Review::getLikes)
                .max()
                .orElse(0);
        return reviews.stream()
                .filter(r->r.getLikes()==maxLikes)
                .toList();
    }
    //list of products sorted by rating;
    public List<String> getProductsSortedByRating(){
        return reviews.stream()
                .collect(Collectors.groupingBy(Review::getProduct,
                        Collectors.averagingDouble(Review::getRating)))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
    //list of products sorted by the number of reviews they have
    public List<String>getProductSortedByReviews(){
        return reviews.stream()
                .collect(Collectors.groupingBy(Review::getProduct, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
    //list of authors sorted by the number of likes under their reviews.
    public List<String>getAuthorsSortedByLikes(){
        return reviews.stream()
                .collect(Collectors.groupingBy(Review::getAuthor,
                        Collectors.summingInt(Review::getLikes)))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}











