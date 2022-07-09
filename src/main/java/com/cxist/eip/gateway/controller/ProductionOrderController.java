package com.cxist.eip.gateway.controller;

import com.cxist.eip.gateway.common.ResponseResult;
import com.cxist.eip.gateway.common.StatusEnum;
import com.cxist.eip.gateway.entity.ProductionOrder;
import com.cxist.eip.gateway.entity.vo.ProductionOrderVo;
import com.cxist.eip.gateway.entity.vo.WorkOrder;
import com.cxist.eip.gateway.service.ProductionOrderService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 * @Description: 生产单据接口
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/ProductionOrder")
public class ProductionOrderController {
    @Resource
    ProductionOrderService productionOrderService;

    @RequestMapping(value = "/save")
    public ResponseResult<Object> save(@RequestBody ProductionOrderVo productionOrderVo){
        try {
            productionOrderService.insert(productionOrderVo);
            List<ProductionOrder> productionOrders = productionOrderVo.getProductionOrders();
            List<WorkOrder> list = new ArrayList<>();
            productionOrders.forEach(productionOrder -> {
                WorkOrder workOrder = new WorkOrder();
                workOrder.setProductionOrderId(productionOrder.getId());
                workOrder.setProductionOrderNo(productionOrder.getProductionOrderNo());
                list.add(workOrder);
            });
            return new ResponseResult<>(true, StatusEnum.OK,list);
        }catch (Exception e){
            return new ResponseResult<>(false, StatusEnum.ERROR,e.getMessage());
        }
    }

    @RequestMapping(value = "/update")
    public ResponseResult<Object> update(ProductionOrder productionOrder){
        try {
            productionOrderService.update(productionOrder);
            return new ResponseResult<>(true, StatusEnum.OK);
        }catch (Exception e){
            return new ResponseResult<>(false, StatusEnum.ERROR,e.getMessage());
        }
    }

    @RequestMapping(value = "/delete")
    public ResponseResult<Object> delete(@RequestBody Map<String,Object> map){
        try {
            ProductionOrder order = new ProductionOrder();
            order.setId((Integer) map.get("productionOrderId"));
            order.setDeclaration((String) map.get("declaration"));
            if (map.get("fileId") != null){
                order.setFileId((Integer)map.get("fileId"));
            }
            productionOrderService.update(order);
            return new ResponseResult<>(true, StatusEnum.OK);
        }catch (Exception e){
            return new ResponseResult<>(false, StatusEnum.ERROR,e.getMessage());
        }
    }

}
