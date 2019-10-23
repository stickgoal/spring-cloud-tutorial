package com.woniuxy.architectcourse.cloud.hystixdemo.client;

import com.woniuxy.architectcourse.cloud.hystixdemo.model.Review;
import com.woniuxy.architectcourse.cloud.hystixdemo.web.MovieController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;

//@FeignClient(value = "review", fallback = ReviewClientFallBack.class)
@FeignClient(value = "review", fallbackFactory = ReviewClientFallBackFactory.class)
public interface ReviewClient {

    @RequestMapping(method = RequestMethod.GET, value = "/review/{reviewId}")
    public Review findReviewById(@PathVariable("reviewId") int reviewId);

}
