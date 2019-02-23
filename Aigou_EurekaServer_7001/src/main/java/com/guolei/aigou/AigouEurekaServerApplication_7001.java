package com.guolei.aigou;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AigouEurekaServerApplication_7001 {

    public static void main(String[] args) {
        SpringApplication.run(AigouEurekaServerApplication_7001.class, args);
    }
}
