package com.fh.bean.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_dept")
public class DeptBeanPo {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id; //部门ID
    @TableField("deptName")
    private String deptName;//部门名称
    @TableField("pid")
    private Integer pid;//父级部门ID
    @TableField("status")
    private Integer status;//部门状态

}
