package com.fh.bean.vo;

import lombok.Data;

@Data
public class DeptBeanVo {

    private Integer id; //部门ID
    private String deptName;//部门名称
    private Integer pid;//父级部门ID
    private Integer status;//部门状态

}
