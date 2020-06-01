package com.xiaopay.service;

import com.xiaopay.entity.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by fengye on 2020/5/31.
 */

/**
 * 调用时会发送 http://microservice-dept/dept/list
 */
@FeignClient(value="microservice-dept")
@RequestMapping(value="/dept")
public interface IDeptClientService {
    /**
     * 查询部门接口
     *
     * @param deptNo 部门编号
     * @return 返回值
     */
    @RequestMapping(value="/get/{id}", method = RequestMethod.GET)
    Dept findDeptByNo(@PathVariable("id") Integer deptNo);

    @RequestMapping(value="/list", method = RequestMethod.GET)
    List<Dept> findAllDept();

    @RequestMapping(value="/add", method = RequestMethod.POST)
    boolean addDept(Dept dept);
}
