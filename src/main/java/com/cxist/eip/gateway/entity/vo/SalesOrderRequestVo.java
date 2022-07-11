package com.cxist.eip.gateway.entity.vo;

import com.cxist.eip.gateway.entity.SalesOrder;
import com.cxist.eip.gateway.entity.SalesOrderLine;
import lombok.Data;
import java.util.List;

/**
 * @Auther Chaos
 * @Date 2022/7/10
 */
@Data
public class SalesOrderRequestVo extends SalesOrder {
    private List<SalesOrderLine> salesOrderLines;
}
