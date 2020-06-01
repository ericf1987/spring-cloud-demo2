package com.xiaopay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by fengye on 2020/5/3.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.xiaopay"})
@ComponentScan("com.xiaopay")
public class DeptConsumerFeignApp {

    public static void main(String[] args) {
        new SpringApplication().run(DeptConsumerFeignApp.class);
    }

}
