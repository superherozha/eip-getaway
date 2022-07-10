package com.cxist.eip.gateway.service;

import com.cxist.eip.gateway.entity.PurchaseOrder;
import com.cxist.eip.gateway.entity.vo.PurchaseOrderVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 */
public interface PurchaseOrderService {
    PageInfo<PurchaseOrder> getPagePurchaseOrder(PurchaseOrderVo purchaseOrderVo);

    void addPurchaseOrder(PurchaseOrder purchaseOrder);

    void batchAddPurchaseOrder(List<PurchaseOrder> purchaseOrders);
}
