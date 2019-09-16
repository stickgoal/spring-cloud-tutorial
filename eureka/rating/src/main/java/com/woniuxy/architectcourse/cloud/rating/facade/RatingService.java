package com.woniuxy.architectcourse.cloud.rating.facade;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingService {

    @RequestMapping("rate")
    public int rate(String movieName){
        System.out.println("收到请求,参数名："+movieName);
        return movieName.length();
    }

}
