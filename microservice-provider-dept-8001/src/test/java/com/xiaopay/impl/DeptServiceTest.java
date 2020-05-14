package com.xiaopay.impl;

import com.xiaopay.BaseTest;
import com.xiaopay.entity.Dept;
import com.xiaopay.service.IDeptService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by fengye on 2020/5/5.
 */
@Slf4j
public class DeptServiceTest extends BaseTest {

    @Autowired
    IDeptService deptService;

    @Test
    public void testFindDeptByNo() throws Exception {
        Dept dept = deptService.findDeptByNo(1);
        log.info("查询部门 -> {}", dept.toString());
    }

    @Test
    public void testFindAllDept() throws Exception {
        List<Dept> allDept = deptService.findAllDept();
        log.info("查询所有部门 -> {}", allDept.toString());
    }

    @Test
    public void testAddDept() throws Exception {
        Dept dept = new Dept();
        dept.setDeptName("行政部");
        boolean result = deptService.addDept(dept);
        log.info("添加成功？{}", result);
    }
}