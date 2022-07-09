package com.cxist.eip.gateway.service;

import com.cxist.eip.gateway.entity.PurchaseOrder;
import com.cxist.eip.gateway.entity.vo.PurchaseOrderVo;
import com.github.pagehelper.PageInfo;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 */
public interface PurchaseOrderService {
    PageInfo<PurchaseOrder> getPagePurchaseOrder(PurchaseOrderVo purchaseOrderVo);
}
