package com.cxist.eip.gateway.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cxist.eip.gateway.common.ResponseResult;
import com.cxist.eip.gateway.common.StatusEnum;
import com.cxist.eip.gateway.entity.PurchaseSalesRel;
import com.cxist.eip.gateway.service.PurchaseSalesRelService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Auther Chaos
 * @Date 2022/7/11
 * @Description: 销售订单行关联采购点单行项目维护接口
 */

@RestController
@CrossOrigin
@RequestMapping(value = "/purchaseSalesRels")
public class PurchaseSalesRelController {
    @Resource
    PurchaseSalesRelService purchaseSalesRelService;

    /**
     * 新增
     * @param body json
     */
    @RequestMapping(value = "/addMapping")
    public ResponseResult<Object> addMapping(@RequestBody String body) {
        try {
            if (StringUtils.isNotBlank(body)){
                JSONArray jsonArray = JSON.parseArray(body);
                Iterator<Object> iterator = jsonArray.stream().iterator();
                List<PurchaseSalesRel> purchaseSalesRelList = new ArrayList<>();
                while (iterator.hasNext()){
                    JSONObject next = (JSONObject)iterator.next();
                    Integer salesOrderLineId = (Integer)next.get("salesOrderLineId");
                    List<Integer> salesOrderLineIds = (List<Integer>)next.get("purchaseOrderLineIds");
                    salesOrderLineIds.forEach(id -> {
                        PurchaseSalesRel purchaseSalesRel = new PurchaseSalesRel();
                        purchaseSalesRel.setSalesOrderLineId(salesOrderLineId);
                        purchaseSalesRel.setPurchaseOrderLineId(id);
                        purchaseSalesRelList.add(purchaseSalesRel);
                    });
                }
                purchaseSalesRelService.batchSave(purchaseSalesRelList);
            }
            return new ResponseResult<>(true, StatusEnum.OK);
        } catch (Exception e) {
            return new ResponseResult<>(false, StatusEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 关联 修改
     * @param purchaseSalesRel 关联对象
     */
    @RequestMapping(value = "updateMapping")
    public ResponseResult<Object> updateMapping(@RequestBody PurchaseSalesRel purchaseSalesRel) {
        try {
            purchaseSalesRelService.updateMapping(purchaseSalesRel);
            return new ResponseResult<>(true, StatusEnum.OK);
        } catch (Exception e) {
            return new ResponseResult<>(false, StatusEnum.ERROR, e.getMessage());
        }
    }

}
