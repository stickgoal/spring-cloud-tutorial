package com.woniuxy.architectcourse.cloud.woniueurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class WoniuEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WoniuEurekaServerApplication.class, args);
    }

}
