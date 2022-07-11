package com.cxist.eip.gateway.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cxist.eip.gateway.common.ResponseResult;
import com.cxist.eip.gateway.common.StatusEnum;
import com.cxist.eip.gateway.entity.SalesOrder;
import com.cxist.eip.gateway.entity.SalesOrderLine;
import com.cxist.eip.gateway.entity.vo.SalesOrderRequestVo;
import com.cxist.eip.gateway.service.SalesOrderLineService;
import com.cxist.eip.gateway.service.SalesOrderService;
import org.springframework.beans.BeanUtils;
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
     * 销售订单新增
     * @param body 销售订单
     */
    @RequestMapping(value = "/addSalesOrder")
    @Transactional
    public ResponseResult<Object> addSalesOrder(@RequestBody String body){
        try {
            SalesOrderRequestVo salesOrderRequestVo = JSON.parseObject(body, SalesOrderRequestVo.class);
            SalesOrder salesOrder = new SalesOrder();
            BeanUtils.copyProperties(salesOrderRequestVo,salesOrder);
            salesOrderService.addSalesOrder(salesOrder);
            List<SalesOrderLine> salesOrderLines = salesOrderRequestVo.getSalesOrderLines();
            for (SalesOrderLine salesOrderLine : salesOrderLines) {
                salesOrderLine.setSalesOrderNo(salesOrder.getSalesOrderNo());
                salesOrderLine.setSalesOrderId(salesOrder.getSalesOrderId());
            }
            salesOrderLineService.batchSave(salesOrderLines);
            Map<String, Object> map = new HashMap<>();
            map.put("salesOrderId",salesOrder.getSalesOrderId());
            map.put("salesOrderLines",salesOrderLines);
            return new ResponseResult<>(true, StatusEnum.OK, map);
        }catch (Exception e){
            return new ResponseResult<>(false, StatusEnum.ERROR,e.getMessage());
        }
    }

    /**
     * 销售订单修改
     * @param body 销售订单
     */
    @RequestMapping(value = "/updateSalesOrder")
    @Transactional
    public ResponseResult<Object> updateSalesOrder(@RequestBody String body){
        try {
            SalesOrderRequestVo salesOrderRequestVo = JSON.parseObject(body, SalesOrderRequestVo.class);
            SalesOrder salesOrder = new SalesOrder();
            BeanUtils.copyProperties(salesOrderRequestVo,salesOrder);
            salesOrderService.updateSalesOrder(salesOrder);
            List<SalesOrderLine> salesOrderLines = salesOrderRequestVo.getSalesOrderLines();
            for (SalesOrderLine salesOrderLine : salesOrderLines) {
                salesOrderLine.setSalesOrderNo(salesOrder.getSalesOrderNo());
                salesOrderLine.setSalesOrderId(salesOrder.getSalesOrderId());
            }
            salesOrderLineService.batchUpdate(salesOrderLines);
            Map<String, Object> map = new HashMap<>();
            map.put("salesOrderId",salesOrder.getSalesOrderId());
            map.put("salesOrderLines",salesOrderLines);
            return new ResponseResult<>(true, StatusEnum.OK, JSON.toJSONString(map));
        }catch (Exception e){
            return new ResponseResult<>(false, StatusEnum.ERROR,e.getMessage());
        }
    }

    /**
     * 销售订单删除接口
     * @param body json
     */
    @RequestMapping(value = "/delete")
    public ResponseResult<Object> delete(@RequestBody String body){
        try {
            SalesOrder salesOrder = JSON.parseObject(body,SalesOrder.class);
            salesOrder.setIsDeleted('Y');
            salesOrderService.updateSalesOrder(salesOrder);
            return new ResponseResult<>(true, StatusEnum.OK);
        }catch (Exception e){
            return new ResponseResult<>(false, StatusEnum.ERROR,e.getMessage());
        }
    }
}
