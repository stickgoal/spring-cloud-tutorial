package com.woniuxy.architectcourse.cloud.eurekaserverclustered;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerClusteredApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerClusteredApplication.class, args);
    }

}
