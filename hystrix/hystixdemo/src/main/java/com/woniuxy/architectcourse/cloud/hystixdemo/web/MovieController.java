package com.woniuxy.architectcourse.cloud.hystixdemo.web;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
public class MovieController {

    private Logger logger = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient discoveryClient;

    @RequestMapping("review/{reviewId}")
    @HystrixCommand(fallbackMethod = "findReviewFallback",
            commandProperties = @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value ="5" )
    )
    public Review findReview(@PathVariable("reviewId") int reviewId){
        return restTemplate.getForObject(getUrl()+"/review/{reviewId}",Review.class,reviewId);
    }

    //方法上加入Throwable参数则可以自动获取到降级原因
    public Review findReviewFallback(int reviewId,Throwable throwable){
        Review review = new Review(-1,-1,-1,"暂无内容",new Date());
        logger.warn("访问review服务出现故障，执行降级服务，错误原因：",throwable);
        return review;
    }

    private String getUrl() {
        return discoveryClient.getNextServerFromEureka("review",false).getHomePageUrl();
    }

}
