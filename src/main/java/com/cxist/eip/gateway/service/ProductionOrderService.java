package com.cxist.eip.gateway.service;

import com.cxist.eip.gateway.entity.ProductionOrder;
import com.cxist.eip.gateway.entity.vo.ProductionOrderVo;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 */
public interface ProductionOrderService {
    void insert(ProductionOrderVo productionOrderVo);

    void update(ProductionOrder productionOrder);
}
