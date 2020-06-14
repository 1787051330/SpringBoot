package com.fh.bean.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_role")
public class RoleBeanPo {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id; //角色主键ID
    @TableField("roleKey")
    private String roleKey;//角色关键字[角色权限]
    @TableField("roleName")
    private String roleName;//角色名称

}
