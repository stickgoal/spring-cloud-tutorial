package com.woniuxy.cloud.zuuldemo.aggregation;

import java.util.List;

public class UserAndReview extends User{

    private List<Review> reviewList;

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

}
