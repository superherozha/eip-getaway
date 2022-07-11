package com.cxist.eip.gateway.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 */
@Data
public class PurchaseOrderLine {
    @TableId(value = "purchase_order_line_id",type = IdType.AUTO)
    private String purchaseOrderLineId;
    private String purchaseOrderNo;
    private Integer purchaseOrderId;
    private String purchaseOrderLineNo;
    private String materialCode;
    private String materialName;
    private String projectCode;
    private String projectName;
    private BigDecimal materialNum;
    private String materialUnit;
    private String materialMaxCategoryCode;
    private String materialMaxCategoryName;
    private String materialMedCategoryCode;
    private String materialMedCategoryName;
    private String materialMinCategoryCode;
    private String materialMinCategoryName;
    private String subclassCode;
    private String subclassName;
    private String deliveryPlanDate;
    private String status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT")
    private Date createdTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT")
    private Date updatedTime;
    @TableField(value = "gmt_created",fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT")
    private Date gmtCreated;
    @TableField(value = "gmt_updated",fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT")
    private Date gmtUpdated;
    @TableField(value = "is_deleted",fill = FieldFill.INSERT)
    private char isDeleted;
}
