package com.woniuxy.cloud.zuuldemo.aggregation;

/**
 * 评论对象
 */
public class Review {

    private int reviewId;

    private int movieId;

    private String movieName;

    private String content;

    public Review() {
    }

    public Review(int reviewId, int movieId, String movieName, String content) {
        this.reviewId = reviewId;
        this.movieId = movieId;
        this.movieName = movieName;
        this.content = content;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
