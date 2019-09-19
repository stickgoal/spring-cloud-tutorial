package com.woniuxy.architectcourse.cloud.servicecall.client;

import com.woniuxy.architectcourse.cloud.servicecall.Review;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@FeignClient("review")
public interface ReviewClient {

    @RequestMapping(method = RequestMethod.POST,value="/review")
    public String addReview(@RequestBody Review review);

    @RequestMapping(method = RequestMethod.GET,value="/review/{reviewId}")
    public Review findReviewById(@PathVariable("reviewId") int reviewId);

    @RequestMapping(method = RequestMethod.GET,value="/movie/{movieId}/reviews")
    public List<Review> findReviewByMovieId(@PathVariable("movieId")int movieId);

}