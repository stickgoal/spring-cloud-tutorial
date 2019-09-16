package com.woniuxy.architectcourse.cloud.movie.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient discoveryClient;

    @RequestMapping("movie/detail")
    @ResponseBody
    public String showMovie(String movieName, ModelMap modelMap){
    //通过EurekaClient从EurekaServer获取服务列表，默认使用简单地轮询机制，轮流获取可用的服务
    InstanceInfo instance = discoveryClient.getNextServerFromEureka("rating", false);
    String serviceUrl= instance.getHomePageUrl();

    //使用restTemplate调用远程服务
      int credit =  restTemplate.getForObject(serviceUrl+"/rate?movieName="+movieName,Integer.class);

      return "电影【"+movieName+"】的评分为"+credit;
    }

}
