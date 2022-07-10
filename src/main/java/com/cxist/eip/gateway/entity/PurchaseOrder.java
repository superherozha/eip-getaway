package com.cxist.eip.gateway.entity;

import lombok.Data;
import java.util.Date;
import java.util.List;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 * @Description: 采购订单对象
 */
@Data
public class PurchaseOrder {
    private Integer id;
    private String source;
    private String purchaserOrderNo;
    private String contractNo;
    private String contractName;
    private String contractSignDate;
    private String buyerName;
    private String buyerCode;
    private String sellerName;
    private String sellerCode;
    private String contractTypeCode;
    private String contractTypeName;
    private String lineNumber;
    private String syncType;
    private Date createdTime;
    private Date updatedTime;
    private char isDeleted;

    private List<PurchaseOrderLine> purchaseOrderLine;
}
