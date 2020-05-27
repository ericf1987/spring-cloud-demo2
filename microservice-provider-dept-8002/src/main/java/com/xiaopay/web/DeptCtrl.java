package com.xiaopay.web;

import com.xiaopay.entity.Dept;
import com.xiaopay.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by fengye on 2020/5/5.
 */
@RequestMapping(value="/dept")
@RestController
public class DeptCtrl {

    @Autowired
    IDeptService deptService;

    @Autowired
    DiscoveryClient discoveryClient;

    @PostMapping
    @RequestMapping(value="/add")
    public boolean add(@RequestBody Dept dept){
        boolean b = deptService.addDept(dept);
        return b;
    }

    @GetMapping
    @RequestMapping(value="/get/{deptNo}")
    public Dept get(@PathVariable("deptNo") Integer deptNo){
        return deptService.findDeptByNo(deptNo);
    }

    @GetMapping
    @RequestMapping(value="/list")
    public List<Dept> list(){
        return deptService.findAllDept();
    }

    @GetMapping
    @RequestMapping(value="/discovery")
    public void discovery(){
        List<ServiceInstance> instances = discoveryClient.getInstances("microservice-dept");

        instances.stream().forEach(i -> System.out.println("当前服务实例：" + i.getInstanceId() + " " + i.getHost() + " " + i.getServiceId() + " " + i.getUri()));
    }

}
