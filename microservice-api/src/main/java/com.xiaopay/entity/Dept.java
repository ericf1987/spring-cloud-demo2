package com.xiaopay.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Created by fengye on 2020/5/3.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Dept implements Serializable{

    /**
     * 部门ID
     */
    private Long deptNo;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 来自哪个数据库，微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同的数据库
     */
    private String dbSource;

}
