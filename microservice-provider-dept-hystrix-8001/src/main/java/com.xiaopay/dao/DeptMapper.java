package com.xiaopay.dao;

import com.xiaopay.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by fengye on 2020/5/3.
 */
@Mapper
public interface DeptMapper {

    /**
     * 查询部门
     *
     * @param deptNo 部门编号
     * @return 返回值
     */
    Dept findDeptByNo(Integer deptNo);

    /**
     * 查询部门列表
     *
     * @return
     */
    List<Dept> findAllDept();

    /**
     * 添加部门
     *
     * @return
     */
    boolean addDept(Dept dept);

}
