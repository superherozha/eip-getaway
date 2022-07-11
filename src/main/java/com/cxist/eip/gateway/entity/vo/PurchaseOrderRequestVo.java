package com.cxist.eip.gateway.entity.vo;

import com.cxist.eip.gateway.entity.PurchaseOrder;
import com.cxist.eip.gateway.entity.PurchaseOrderLine;
import lombok.Data;

import java.util.List;

/**
 * @Auther Chaos
 * @Date 2022/7/10
 */
@Data
public class PurchaseOrderRequestVo extends PurchaseOrder {
    private List<PurchaseOrderLine> purchaseOrderLineList;
}
