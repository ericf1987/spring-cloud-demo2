package com.xiaopay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import ribbon.rule.MySelfRule;

/**
 * Created by fengye on 2020/5/3.
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="microservice-dept", configuration = MySelfRule.class)
public class DeptConsumer9001App {

    public static void main(String[] args) {
        new SpringApplication().run(DeptConsumer9001App.class);
    }

}
