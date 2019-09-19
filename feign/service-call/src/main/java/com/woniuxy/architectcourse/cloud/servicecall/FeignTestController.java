package com.woniuxy.architectcourse.cloud.servicecall;

import com.netflix.appinfo.InstanceInfo;
import com.woniuxy.architectcourse.cloud.servicecall.client.ReviewClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("feign")
public class FeignTestController {

    @Autowired
    private ReviewClient reviewClient;

    @RequestMapping("addReview")
    public String addReview() {
        Review review = new Review(1, 1, 1, "好电影，有内涵", new Date());
        return reviewClient.addReview(review);
    }

    @RequestMapping("findReview")
    public Review findReview(int reviewId) {
        return reviewClient.findReviewById(reviewId);
    }

    @RequestMapping("findReviewList")
    public List findReviewList(int movieId) {
        System.out.println("电影ID" + movieId);
        return reviewClient.findReviewByMovieId(movieId);
    }

}
