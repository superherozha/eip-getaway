package com.cxist.eip.gateway.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 */
@Data
public class SalesOrderLine {
    private Integer id;
    private String salesOrderLineNo;
    private String salesMaterialCode;
    private String salesMaterialName;
    private String salesMaterialDesc;
    private String salesModel;
    private String salesMaterialNum;
    private String salesMaterialUnit;
    private Integer salesOrderId;
    private String status;
    private String deliveryPlanDate;
    private Date createdTime;
    private Date updatedTime;
    private char isDeleted;
}