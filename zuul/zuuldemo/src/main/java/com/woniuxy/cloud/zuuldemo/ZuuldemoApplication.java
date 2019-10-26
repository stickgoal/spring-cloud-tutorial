package com.woniuxy.cloud.zuuldemo;

import com.woniuxy.cloud.zuuldemo.filters.AuthenticationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableZuulProxy
public class ZuuldemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuuldemoApplication.class, args);
    }

    @Bean
    public AuthenticationFilter authenticationFilter(){
        return new AuthenticationFilter();
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
