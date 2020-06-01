package com.xiaopay.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by fengye on 2020/5/5.
 */
@Configuration
public class DeptConfigBean {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public IRule myselfRule(){
        //负载均衡算法默认是轮询制，也可以自己定义
//        return new MySelfRule(5);

        //随机
        return new RandomRule();

        //过滤掉多次访问故障而处于断路跳闸状态的服务 还有并发连接数超过阈值的服务 然后对剩余列表进行轮询
        //return new AvailabilityFilteringRule();

        //权重
        //return new WeightedResponseTimeRule();

        //轮询 多次失败后过滤失败节点
        //return new RetryRule();

        //return new BestAvailableRule();

        //return new ZoneAvoidanceRule();
    }


}
