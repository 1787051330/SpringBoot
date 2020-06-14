package com.fh.bean.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_right")
public class RightBeanPo {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField("rightName")
    private String rightName;
    @TableField("pathUrl")
    private String pathUrl;
    @TableField("type")
    private Integer type;
    @TableField("pid")
    private Integer pid;
    @TableField("rightKey")
    private String rightKey;
    @TableField("status")
    private Integer status;

}
