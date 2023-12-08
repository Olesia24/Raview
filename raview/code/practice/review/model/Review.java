package practice.review.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Review {
    private long id;
    private int rating;
    private String author;
    private String product;
    private String comment;
    private int likes;
    LocalDateTime data;

    public Review(long id, int rating, String author, String product, String comment, int likes, LocalDateTime data) {
        this.id = id;
        this.rating = rating;
        this.author = author;
        this.product = product;
        this.comment = comment;
        this.likes = likes;
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public String getAuthor() {
        return author;
    }

    public String getProduct() {
        return product;
    }

    public String getComment() {
        return comment;
    }

    public int getLikes() {
        return likes;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", rating=" + rating +
                ", author='" + author + '\'' +
                ", product='" + product + '\'' +
                ", comment='" + comment + '\'' +
                ", likes=" + likes +
                ", data=" + data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return id == review.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
