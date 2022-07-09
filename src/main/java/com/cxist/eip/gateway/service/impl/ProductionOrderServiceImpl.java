package com.cxist.eip.gateway.service.impl;

import com.cxist.eip.gateway.dao.ProductionOrderMapper;
import com.cxist.eip.gateway.entity.ProductionOrder;
import com.cxist.eip.gateway.entity.vo.ProductionOrderVo;
import com.cxist.eip.gateway.service.ProductionOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 */
@Service
public class ProductionOrderServiceImpl implements ProductionOrderService {

    @Resource
    ProductionOrderMapper productionOrderMapper;

    @Override
    public void insert(ProductionOrderVo productionOrderVo) {
        List<ProductionOrder> productionOrders = productionOrderVo.getProductionOrders();
        productionOrders.forEach(productionOrder -> {
            productionOrder.setSalesOrderLineId(productionOrderVo.getSalesOrderLineId());
            productionOrderMapper.insert(productionOrder);
        });
    }

    @Override
    public void update(ProductionOrder productionOrder) {
        productionOrderMapper.updateById(productionOrder);
    }
}
