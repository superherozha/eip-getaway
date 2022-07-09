package com.cxist.eip.gateway.service.impl;

import com.cxist.eip.gateway.dao.SalesOrderMapper;
import com.cxist.eip.gateway.entity.SalesOrder;
import com.cxist.eip.gateway.entity.SalesOrderLine;
import com.cxist.eip.gateway.service.SalesOrderLineService;
import com.cxist.eip.gateway.service.SalesOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 */
@Service
public class SalesOrderServiceImpl implements SalesOrderService {
    @Resource
    SalesOrderMapper salesOrderMapper;

    @Override
    public void save(SalesOrder salesOrder) {
        if (salesOrder.getId() == null){
            salesOrderMapper.insert(salesOrder);
        } else {
            salesOrderMapper.updateById(salesOrder);
        }
    }

}
