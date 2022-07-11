package com.cxist.eip.gateway.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cxist.eip.gateway.dao.ProductionBatchInfoMapper;
import com.cxist.eip.gateway.entity.ProductionBatchInfo;
import com.cxist.eip.gateway.service.ProductionBatchService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 * @Description: 生产批次服务
 */
@Service
public class ProductionBatchServiceImpl implements ProductionBatchService {
    @Resource
    ProductionBatchInfoMapper productionBatchInfoMapper;

    @Override
    public void add(ProductionBatchInfo productionBatch) {
        productionBatchInfoMapper.insert(productionBatch);
    }

    @Override
    public void modify(ProductionBatchInfo productionBatch) {
        UpdateWrapper<ProductionBatchInfo> updateWrapper = new UpdateWrapper<>();
        productionBatchInfoMapper.update(productionBatch,updateWrapper.lambda().
                ge(ProductionBatchInfo::getProductionBatchNo,productionBatch.getProductionBatchNo()));
    }
}
