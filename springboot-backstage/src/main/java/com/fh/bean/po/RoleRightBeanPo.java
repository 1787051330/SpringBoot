package com.fh.bean.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_role_right")
public class RoleRightBeanPo {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField("roleId")
    private Integer roleId;
    @TableField("rightId")
    private Integer rightId;

}
