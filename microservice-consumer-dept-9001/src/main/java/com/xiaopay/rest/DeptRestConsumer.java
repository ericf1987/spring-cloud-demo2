package com.xiaopay.rest;

import com.xiaopay.entity.Dept;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by fengye on 2020/5/5.
 */
@RestController
@Slf4j
public class DeptRestConsumer {

//    public static final String REST_URL_PREFIX = "http://localhost:8001/";
    public static final String REST_URL_PREFIX = "http://MICROSERVICE-DEPT/";

    @Autowired
    RestTemplate restTemplate;


    @RequestMapping(value="/consumer/dept/get/{deptNo}")
    public Dept get(@PathVariable("deptNo") Integer deptNo){
        Dept dept = restTemplate.getForObject(REST_URL_PREFIX + "dept/get/" + deptNo, Dept.class);
        log.info("rest api -> {} ", dept.toString());
        return dept;
    }

    @RequestMapping(value="/consumer/dept/list")
    public List<Dept> list(){
        List<Dept> deptList = restTemplate.getForObject(REST_URL_PREFIX + "dept/list", List.class);
        log.info("rest api -> {} ", deptList.toString());
        return deptList;
    }

    @RequestMapping(value="/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX + "dept/add", dept, Boolean.class);
    }


}
