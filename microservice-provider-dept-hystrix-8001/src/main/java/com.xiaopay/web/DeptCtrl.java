package com.xiaopay.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    @HystrixCommand(fallbackMethod = "postGetDept")
    public Dept get(@PathVariable("deptNo") Integer deptNo){
        Dept dept = deptService.findDeptByNo(deptNo);
        if(null == dept){
            throw new RuntimeException("查询出错！");
        }
        return dept;
    }

    public Dept postGetDept(@PathVariable("deptNo") Integer deptNo){
        Dept dept = new Dept();
        dept.setDeptNo(Long.valueOf(deptNo));
        dept.setDeptName("默认部门");
        dept.setDbSource("数据源查询失败，请检查ID");
        return dept;
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
