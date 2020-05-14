package com.xiaopay.service;

import com.xiaopay.entity.Dept;

import java.util.List;

/**
 * Created by fengye on 2020/5/5.
 */
public interface IDeptService {

    /**
     * 查询部门接口
     *
     * @param deptNo 部门编号
     * @return 返回值
     */
    Dept findDeptByNo(Integer deptNo);

    List<Dept> findAllDept();

    boolean addDept(Dept dept);

}
