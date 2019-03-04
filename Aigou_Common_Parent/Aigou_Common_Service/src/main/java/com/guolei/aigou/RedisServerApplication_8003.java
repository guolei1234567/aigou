package com.guolei.aigou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RedisServerApplication_8003 {

    public static void main(String[] args) {
        SpringApplication.run(RedisServerApplication_8003.class, args);
    }
}
