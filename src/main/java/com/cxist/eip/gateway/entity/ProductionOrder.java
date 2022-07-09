package com.cxist.eip.gateway.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 */
@Data
public class ProductionOrder {
    private Integer id;
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
    private Date createdTime;
    private Date updatedTime;
    private char isDeleted;
}
