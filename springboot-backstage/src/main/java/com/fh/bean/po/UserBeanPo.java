package com.fh.bean.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("t_user")
public class UserBeanPo {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;//用户主键ID
    @TableField("userName")
    private String userName;//用户名
    @TableField("realName")
    private String realName;//真实姓名
    @TableField("password")
    private String password;//用户密码
    @TableField("birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;//用户生日
    @TableField("sex")
    private Integer sex;//用户性别
    @TableField("phone")
    private String phone;//用户手机号码
    @TableField("email")
    private String email;//用户邮箱
    @TableField("idcard")
    private String idcard;//身份证号
    @TableField("provinceCode")
    private String provinceCode;//省的编码
    @TableField("cityCode")
    private String cityCode;//市的编码
    @TableField("areaCode")
    private String areaCode;//县&区的编码
    @TableField("imgUrl")
    private String imgUrl;//个人头像路径
    @TableField("status")
    private Integer status;//用户状态
    @TableField("deptId")
    private Integer deptId;//部门ID

}
