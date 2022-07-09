package com.cxist.eip.gateway.service.impl;

import com.cxist.eip.gateway.dao.SalesOrderLineMapper;
import com.cxist.eip.gateway.entity.SalesOrderLine;
import com.cxist.eip.gateway.service.SalesOrderLineService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 * @Description: 销售订单服务
 */
@Service
public class SalesOrderLineServiceImpl implements SalesOrderLineService {
    @Resource
    SalesOrderLineMapper salesOrderLineMapper;

    @Override
    public void save(SalesOrderLine salesOrderLine) {
        if (salesOrderLine.getId() == null){
            salesOrderLineMapper.insert(salesOrderLine);
        } else {
            salesOrderLineMapper.updateById(salesOrderLine);
        }
    }

    @Override
    public void batchSave(List<SalesOrderLine> salesOrderLines) {
        salesOrderLines.forEach(this::save);
    }
}
