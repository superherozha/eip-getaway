package com.cxist.eip.gateway.entity.vo;

import lombok.Data;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 */
@Data
public class PurchaseOrderVo extends CommonVo{
    private String source;
    private String purchaseOrderNo;
    private String contractNo;
    private String purchaseOrderId;
    private String updatedStartTime;
    private String updatedEndTime;
    private String ContractSignStartDate;
    private String ContractSignEndDate;
}
