package com.woniuxy.architectcourse.cloud.hystixdemo.client;

import com.woniuxy.architectcourse.cloud.hystixdemo.model.Review;
import com.woniuxy.architectcourse.cloud.hystixdemo.web.MovieController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ReviewClientFallBack implements ReviewClient{
    public static final Logger logger = LoggerFactory.getLogger(MovieController.class);

    @Override
    public Review findReviewById(int reviewId) {
        Review review = new Review(-1, -1, -1, "暂无内容", new Date());

        return review;
    }
}
