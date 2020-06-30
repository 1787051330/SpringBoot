package com.fh.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author xiezhuang
 * @ClassName ProductBeanPo
 * @date 2020/6/30 12:32
 */
@Data
@TableName("t_shop_product")
public class ProductBeanPo {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField("name")
    private String name;
    @TableField("subtitle")
    private String subtitle;
    @TableField("detail")
    private String detail;
    @TableField("price")
    private BigDecimal price;
    @TableField("stock")
    private Integer stock;
    @TableField("status")
    private Integer status;
    @TableField("create_time")
    private LocalDateTime createTime;

}
