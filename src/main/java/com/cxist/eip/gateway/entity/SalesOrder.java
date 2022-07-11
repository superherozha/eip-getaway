package com.cxist.eip.gateway.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;
import java.util.List;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 */
@Data
public class SalesOrder {
    @TableId(value = "sales_order_id",type = IdType.AUTO)
    private Integer salesOrderId;
    private String salesOrderNo;
    private String purchaserCode;
    private String purchaserName;
    private String buyerName;
    private String buyerCode;
    private String sellerName;
    private String sellerCode;
    private String deliveryPlanDate;
    private String contractSignDate;
    private String declaration;
    private String status;
    private String fileId;
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gmtCreated;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gmtUpdated;
    @TableField(fill = FieldFill.INSERT)
    private char isDeleted;
}
