package com.cxist.eip.gateway.entity;

import lombok.Data;
import java.util.Date;
import java.util.List;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 */
@Data
public class SalesOrder {
    private Integer id;
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
    private Date createdTime;
    private Date updatedTime;
    private String isDeleted;
    private List<SalesOrderLine> salesOrderLines;
}
