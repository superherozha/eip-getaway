package com.cxist.eip.gateway.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 */
@Data
public class PurchaseOrderLine {
    private Integer id;
    private String purchaseOrderId;
    private String purchaseOrderLineNo;
    private String purchaseOrderLineId;
    private String materialCode;
    private String materialName;
    private String projectCode;
    private String projectName;
    private String materialNum;
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
    private Date createdTime;
    private Date updatedTime;
    private char isDeleted;
}
