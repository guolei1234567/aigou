package com.guolei.aigou.plat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EmployeeServiceApplication_8001 {

    public static void main(String[] args) {
//        合并主干----》在主干
        /**
         * 文档注释
         */
        SpringApplication.run(EmployeeServiceApplication_8001.class, args);
        System.out.println("主干");
    }
}
