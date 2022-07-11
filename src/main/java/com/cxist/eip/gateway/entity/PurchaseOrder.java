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
 * @Description: 采购订单对象
 */
@Data
public class PurchaseOrder {
    @TableId(value = "purchase_order_id",type = IdType.AUTO)
    private Integer purchaseOrderId;
    private String source;
    private String purchaseOrderNo;
    private String contractNo;
    private String contractName;
    private String contractSignDate;
    private String buyerName;
    private String buyerCode;
    private String sellerName;
    private String sellerCode;
    private String contractTypeCode;
    private String contractTypeName;
    private Integer lineNumber;
    private String syncType;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updatedTime;
    @TableField(value = "gmt_created",fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gmtCreated;
    @TableField(value = "gmt_updated",fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gmtUpdated;
    @TableField(value = "is_deleted",fill = FieldFill.INSERT)
    private char isDeleted;
}
