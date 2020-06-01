package com.xiaopay.impl;

import com.xiaopay.dao.DeptMapper;
import com.xiaopay.entity.Dept;
import com.xiaopay.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fengye on 2020/5/5.
 */
@Service
public class DeptService implements IDeptService {

    @Autowired
    DeptMapper deptMapper;

    @Override
    public Dept findDeptByNo(Integer deptNo) {
        return deptMapper.findDeptByNo(deptNo);
    }

    @Override
    public List<Dept> findAllDept() {
        return deptMapper.findAllDept();
    }

    @Override
    public boolean addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }
}
