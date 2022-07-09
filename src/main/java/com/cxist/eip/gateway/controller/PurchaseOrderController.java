package com.cxist.eip.gateway.controller;

import com.cxist.eip.gateway.common.ResponseResult;
import com.cxist.eip.gateway.common.StatusEnum;
import com.cxist.eip.gateway.entity.vo.PurchaseOrderVo;
import com.cxist.eip.gateway.service.PurchaseOrderService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 * @Description: 采购订单接口
 */
@RestController
@CrossOrigin
public class PurchaseOrderController {

    @Resource
    PurchaseOrderService purchaseOrderService;

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

}
