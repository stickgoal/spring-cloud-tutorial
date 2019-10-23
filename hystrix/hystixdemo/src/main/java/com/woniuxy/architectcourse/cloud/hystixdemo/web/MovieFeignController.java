package com.woniuxy.architectcourse.cloud.hystixdemo.web;

import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.woniuxy.architectcourse.cloud.hystixdemo.client.ReviewClient;
import com.woniuxy.architectcourse.cloud.hystixdemo.model.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RestController
public class MovieFeignController {

    private Logger logger = LoggerFactory.getLogger(MovieFeignController.class);

    @Autowired
    private ReviewClient reviewClient;

    @RequestMapping("review/feign/{reviewId}")
    public Review findReview(@PathVariable("reviewId") int reviewId){
        return reviewClient.findReviewById(reviewId);
    }

}
