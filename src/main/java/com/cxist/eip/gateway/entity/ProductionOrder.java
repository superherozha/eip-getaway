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
public class ProductionOrder {
    @TableId(value = "production_order_id",type = IdType.AUTO)
    private Integer productionOrderId;
    private Integer salesOrderLineId;
    private String productionOrderNo;
    private String productionMaterialCode;
    private String productionMaterialName;
    private String productionMaterialDesc;
    private String productionMaterialNum;
    private String productionMaterialUnit;
    private String planStartDate;
    private String planEndDate;
    private String status;
    private String actualStartDate;
    private String actualEndDate;
    private String declaration;
    private Integer fileId;
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gmtCreated;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gmtUpdated;
    @TableField(fill = FieldFill.INSERT)
    private char isDeleted;
}
