package com.guolei.aigou;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class AigouZuulServerApplication_9527 {
//origin
    public static void main(String[] args) {
        SpringApplication.run(AigouZuulServerApplication_9527.class, args);
    }
}
