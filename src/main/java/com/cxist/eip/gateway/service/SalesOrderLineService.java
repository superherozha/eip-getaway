package com.cxist.eip.gateway.service;

import com.cxist.eip.gateway.entity.SalesOrderLine;

import java.util.List;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 */
public interface SalesOrderLineService {

    void save(SalesOrderLine salesOrderLine);

    void batchSave(List<SalesOrderLine> salesOrderLines);
}
