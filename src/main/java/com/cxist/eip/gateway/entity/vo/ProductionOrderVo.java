package com.cxist.eip.gateway.entity.vo;

import com.cxist.eip.gateway.entity.ProductionOrder;
import lombok.Data;

import java.util.List;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 */
@Data
public class ProductionOrderVo {
    private Integer salesOrderLineId;
    private List<ProductionOrder> productionOrders;
}
