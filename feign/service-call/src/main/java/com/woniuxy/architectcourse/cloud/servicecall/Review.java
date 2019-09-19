package com.woniuxy.architectcourse.cloud.servicecall;

import java.util.Date;

/**
 * 评论对象
 */
public class Review {
    /**
     * 评论ID
     */
    private int reviewId;

    /**
     * 电影Id
     */
    private int movieId;
    /**
     * 用户Id
     */
    private int userId;
    /**
     * 内容
     */
    private String content;
    /**
     * 发布时间
     */
    private Date publishTime;

    public Review(int reviewId, int movieId, int userId, String content, Date publishTime) {
        this.reviewId = reviewId;
        this.movieId = movieId;
        this.userId = userId;
        this.content = content;
        this.publishTime = publishTime;
    }

    public Review(){}

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }


    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ",movieId=" + movieId +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", publishTime=" + publishTime +
                '}';
    }
}
