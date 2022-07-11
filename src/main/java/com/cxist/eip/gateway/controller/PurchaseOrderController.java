package com.cxist.eip.gateway.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.cxist.eip.gateway.common.ResponseResult;
import com.cxist.eip.gateway.common.StatusEnum;
import com.cxist.eip.gateway.entity.PurchaseOrder;
import com.cxist.eip.gateway.entity.PurchaseOrderLine;
import com.cxist.eip.gateway.entity.vo.PurchaseOrderRequestVo;
import com.cxist.eip.gateway.entity.vo.PurchaseOrderVo;
import com.cxist.eip.gateway.service.PurchaseOrderLineService;
import com.cxist.eip.gateway.service.PurchaseOrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 * @Description: 采购订单接口
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/purchaseOrder")
public class PurchaseOrderController {

    @Resource
    PurchaseOrderService purchaseOrderService;

    @Resource
    PurchaseOrderLineService purchaseOrderLineService;

    /**
     * 采购订单查询接口
     * @param purchaseOrderVo 参数对象
     */
    @RequestMapping(value = "/getPurchaseOrder")
    public ResponseResult<Object> getPurchaseOrder(@RequestBody PurchaseOrderVo purchaseOrderVo){
        try {
            return new ResponseResult<>(true, StatusEnum.OK,purchaseOrderService.getPagePurchaseOrder(purchaseOrderVo));
        }catch (Exception e){
            return new ResponseResult<>(false, StatusEnum.ERROR,e.getMessage());
        }
    }

    @RequestMapping(value = "/add")
    @Transactional
    public ResponseResult<Object> add(@RequestBody String body){
        try {
            List<PurchaseOrderRequestVo> purchaseOrders = JSON.parseArray(body, PurchaseOrderRequestVo.class);
            List<PurchaseOrderLine> purchaseOrderLineList = new ArrayList<>();
            if (CollectionUtils.isNotEmpty(purchaseOrders)){
                ArrayList<PurchaseOrder> purchaseOrderList = new ArrayList<>();
                for (PurchaseOrderRequestVo purchaseOrderVo : purchaseOrders) {
                    PurchaseOrder purchaseOrder = new PurchaseOrder();
                    BeanUtils.copyProperties(purchaseOrderVo, purchaseOrder);
                    purchaseOrderList.add(purchaseOrder);
                    if (purchaseOrderVo.getPurchaseOrderLineList() != null) {
                        List<PurchaseOrderLine> purchaseOrderLines = purchaseOrderVo.getPurchaseOrderLineList();
                        if (CollectionUtils.isNotEmpty(purchaseOrders)) {
                            purchaseOrderLines.forEach(purchaseOrderLine -> {
                                purchaseOrderLine.setPurchaseOrderNo(purchaseOrder.getPurchaseOrderNo());
                                purchaseOrderLine.setPurchaseOrderId(purchaseOrder.getPurchaseOrderId());
                            });
                            purchaseOrderLineList.addAll(purchaseOrderLines);
                        }
                    }
                }
                purchaseOrderService.batchAddPurchaseOrder(purchaseOrderList);
                purchaseOrderLineService.batchAddPurchaseOrderLine(purchaseOrderLineList);
            }
            return new ResponseResult<>(true, StatusEnum.OK);
        }catch (Exception e){
            return new ResponseResult<>(false, StatusEnum.ERROR,e.getMessage());
        }
    }

}
