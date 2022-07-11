package com.cxist.eip.gateway.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 */
@Data
public class SalesOrderLine {
    @TableId(value = "sales_order_line_id",type = IdType.AUTO)
    private String salesOrderLineId;
    private String salesOrderLineNo;
    private String salesMaterialCode;
    private String salesMaterialName;
    private String salesMaterialDesc;
    private String salesModel;
    private String salesMaterialNum;
    private String salesMaterialUnit;
    private Integer salesOrderId;
    private String salesOrderNo;
    private String status;
    private String deliveryPlanDate;
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gmtCreated;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gmtUpdated;
    @TableField(fill = FieldFill.INSERT)
    private char isDeleted;
}