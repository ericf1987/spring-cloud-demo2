package com.xiaopay.rest;

import com.xiaopay.entity.Dept;
import com.xiaopay.service.IDeptClientService;
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

    @Autowired
    private IDeptClientService deptClientService;

    @RequestMapping(value="/consumer/dept/get/{deptNo}")
    public Dept get(@PathVariable("deptNo") Integer deptNo){
        return deptClientService.findDeptByNo(deptNo);
    }

    @RequestMapping(value="/consumer/dept/list")
    public List<Dept> list(){
        return deptClientService.findAllDept();
    }

    @RequestMapping(value="/consumer/dept/add")
    public boolean add(Dept dept){
        return deptClientService.addDept(dept);
    }


}
