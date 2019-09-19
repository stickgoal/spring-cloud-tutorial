package com.woniuxy.architectcourse.cloud.servicecall;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("lb")
public class RestTemplateLBTestController {

    @Autowired
    private RestTemplate lbRestTemplate;

    @RequestMapping("addReview")
    public String addReview(){
        Review review =  new Review(1,1,1,"好电影，有内涵", new Date());
       return lbRestTemplate.postForObject(getUrl()+"/review",review,String.class);
    }

    @RequestMapping("findReview")
    public Review findReview(int reviewId){
        return lbRestTemplate.getForObject(getUrl()+"/review/{reviewId}",Review.class,reviewId);
    }

    @RequestMapping("findReviewList")
    public List findReviewList(int movieId){
        System.out.println("movieId="+movieId);
        return lbRestTemplate.getForObject(getUrl()+"/movie/{movieId}/reviews", List.class,movieId);
    }

    private String getUrl() {
        return "http://REVIEW";
    }

}
