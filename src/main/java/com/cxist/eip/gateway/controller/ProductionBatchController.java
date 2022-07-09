package com.cxist.eip.gateway.controller;

import com.cxist.eip.gateway.common.ResponseResult;
import com.cxist.eip.gateway.common.StatusEnum;
import com.cxist.eip.gateway.entity.ProductionBatchInfo;
import com.cxist.eip.gateway.service.ProductionBatchService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 * @Description: 生产批次接口
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/productionBatch")
public class ProductionBatchController {

    @Resource
    ProductionBatchService productionBatchService;

    @RequestMapping(value = "/save")
    public ResponseResult<Object> save(ProductionBatchInfo productionBatchInfo){
        try {
            productionBatchService.save(productionBatchInfo);
            return new ResponseResult<>(true, StatusEnum.OK,productionBatchInfo.getId());
        }catch (Exception e){
            return new ResponseResult<>(false, StatusEnum.ERROR,e.getMessage());
        }
    }

}
