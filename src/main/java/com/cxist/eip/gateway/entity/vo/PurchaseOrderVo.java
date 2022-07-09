package com.cxist.eip.gateway.entity.vo;

import lombok.Data;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 */
@Data
public class PurchaseOrderVo extends CommonVo{
    private String source;
    private String purchaserOrderNo;
    private String contractNo;
    private String purchaseOrderId;
}
