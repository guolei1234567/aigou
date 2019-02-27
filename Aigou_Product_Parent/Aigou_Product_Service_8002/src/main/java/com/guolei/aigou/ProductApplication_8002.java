package com.guolei.aigou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.guolei.aigou.mapper")
public class ProductApplication_8002 {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication_8002.class, args);
    }
}
