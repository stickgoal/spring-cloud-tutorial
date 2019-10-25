package com.woniuxy.architectcourse.cloud.servicecall.review.api;

import com.woniuxy.architectcourse.cloud.servicecall.review.api.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class ReviewManageController {

    @Autowired
    private Environment env;

    @RequestMapping(method = RequestMethod.POST,value="/review")
    public String addReview(@RequestBody Review review){
        System.out.println("添加评论，参数为"+review);
        return "端口是："+env.getProperty("local.server.port");
    }

    @RequestMapping(method = RequestMethod.GET,value="/review/{reviewId}")
    public Review findReviewById(@PathVariable("reviewId") int reviewId){
        System.out.println("查找评论，参数为"+reviewId);
        return new Review(reviewId,1,1,"好电影，有内涵", new Date());
    }

    /**
     * 获取某部电影的所有评论
     */
    @RequestMapping(method = RequestMethod.GET,value="/movie/{movieId}/reviews")
    public List<Review> findReviewByMovieId(@PathVariable("movieId")int movieId){
        System.out.println("查找某部电影评论，参数为"+movieId);
        List<Review> reviews = new ArrayList<>();
        reviews.add(new Review(1,movieId,1,"好电影，有内涵", new Date()));
        reviews.add(new Review(2,movieId,2,"good", new Date()));
        reviews.add(new Review(3,movieId,3,"yes,bravo!", new Date()));
        return reviews;
    }

}
