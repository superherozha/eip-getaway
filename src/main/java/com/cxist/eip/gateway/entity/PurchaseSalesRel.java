package com.cxist.eip.gateway.entity;

import lombok.Data;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 */
@Data
public class PurchaseSalesRel {
    private Integer id;
    private String salesOrderLineId;
    private String purchaseOrderLineId;
    private String createdTime;
    private String updatedTime;
    private String isDeleted;
}
