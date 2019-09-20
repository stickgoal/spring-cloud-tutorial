package com.woniuxy.architectcourse.cloud.hystixdemo.web;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.woniuxy.architectcourse.cloud.hystixdemo.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient discoveryClient;

    @RequestMapping("reivew/{reviewId}")
    @HystrixCommand(fallbackMethod = "findReviewFallback")
    public Review findReview(@PathVariable("reviewId") int reviewId){
        return restTemplate.getForObject(getUrl()+"/review/{reviewId}",Review.class,reviewId);
    }

    public Review findReviewFallback(int reviewId){
        Review review = new Review(-1,-1,-1,"暂无内容",new Date());
        return review;
    }

    private String getUrl() {
        return discoveryClient.getNextServerFromEureka("review",false).getHomePageUrl();
    }

}
