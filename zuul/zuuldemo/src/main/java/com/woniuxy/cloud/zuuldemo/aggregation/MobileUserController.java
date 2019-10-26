package com.woniuxy.cloud.zuuldemo.aggregation;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("api/mobile")
public class MobileUserController {

     @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("getUserReviews")
    public UserAndReview getUserReviews(int userId){
        //查找用户信息
        User user = restTemplate.getForObject("http://USERS/getUserInfo?userId="+userId,User.class);
        //查找评论信息
        List<Review> reviews = restTemplate.getForObject("http://RATING/getReview?movieName=123", List.class);
        //聚合成一个对象
        UserAndReview userAndReview = new UserAndReview();
        BeanUtils.copyProperties(user,userAndReview);
        userAndReview.setReviewList(reviews);

        return userAndReview;
    }



}
