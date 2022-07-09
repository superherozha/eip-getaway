package com.cxist.eip.gateway.controller;

import com.alibaba.fastjson.JSON;
import com.cxist.eip.gateway.common.ResponseResult;
import com.cxist.eip.gateway.common.StatusEnum;
import com.cxist.eip.gateway.entity.SalesOrder;
import com.cxist.eip.gateway.entity.SalesOrderLine;
import com.cxist.eip.gateway.service.SalesOrderLineService;
import com.cxist.eip.gateway.service.SalesOrderService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 * @Description: 销售订单接口
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/salesOrder")
public class SalesOrderController {
    @Resource
    SalesOrderService salesOrderService;

    @Resource
    SalesOrderLineService salesOrderLineService;

    /**
     * 销售订单新增/修改
     * @param salesOrder 销售订单
     */
    @RequestMapping(value = "/save")
    @Transactional
    public ResponseResult<Object> save(@RequestBody SalesOrder salesOrder){
        try {
            salesOrderService.save(salesOrder);
            List<SalesOrderLine> salesOrderLines = salesOrder.getSalesOrderLines();
            salesOrderLines.forEach(salesOrderLine -> salesOrderLine.setSalesOrderId(salesOrder.getId()));
            salesOrderLineService.batchSave(salesOrderLines);
            Map<String, Object> map = new HashMap<>();
            map.put("salesOrderId",salesOrder.getId());
            map.put("salesOrderLine",salesOrderLines);
            return new ResponseResult<>(true, StatusEnum.OK, JSON.toJSONString(map));
        }catch (Exception e){
            return new ResponseResult<>(false, StatusEnum.ERROR,e.getMessage());
        }
    }
}
