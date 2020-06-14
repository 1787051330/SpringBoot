package com.fh.bean.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class UserBeanVo {
    private Integer id;//用户主键ID
    private String userName;//用户名
    private String realName;//真实姓名
    private String password;//用户密码
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;//用户生日
    private Integer sex;//用户性别
    private String phone;//用户手机号码
    private String email;//用户邮箱
    private String idcard;//身份证号
    private String provinceName;
    private String cityName;
    private String areaName;
    private String imgUrl;//个人头像路径
    private Integer status;//用户状态
    private Integer deptId;//部门ID
    private String deptName;

}
