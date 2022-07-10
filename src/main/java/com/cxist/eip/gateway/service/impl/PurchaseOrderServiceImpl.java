package com.cxist.eip.gateway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.cxist.eip.gateway.dao.PurchaseOrderMapper;
import com.cxist.eip.gateway.entity.PurchaseOrder;
import com.cxist.eip.gateway.entity.vo.PurchaseOrderVo;
import com.cxist.eip.gateway.service.PurchaseOrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 * @Description: 采购订单服务
 */
@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    @Resource
    PurchaseOrderMapper purchaseOrderMapper;

    @Override
    public PageInfo<PurchaseOrder> getPagePurchaseOrder(PurchaseOrderVo purchaseOrderVo) {
        QueryWrapper<PurchaseOrder> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<PurchaseOrder> lambda = queryWrapper.lambda();
        lambda.eq(PurchaseOrder::getIsDeleted,"N");
        if (StringUtils.isNotBlank(purchaseOrderVo.getSource())){
            lambda.eq(PurchaseOrder::getSource, purchaseOrderVo.getSource());
        }
        if (StringUtils.isNotBlank(purchaseOrderVo.getContractNo())){
            lambda.eq(PurchaseOrder::getContractNo, purchaseOrderVo.getContractNo());
        }
        if (StringUtils.isNotBlank(purchaseOrderVo.getUpdatedStartTime()) && StringUtils.isNotBlank(purchaseOrderVo.getUpdatedEndTime())){
            lambda.between(PurchaseOrder::getUpdatedTime, purchaseOrderVo.getUpdatedStartTime(),purchaseOrderVo.getUpdatedEndTime());
        }
        if (StringUtils.isNotBlank(purchaseOrderVo.getUpdatedStartTime()) && StringUtils.isNotBlank(purchaseOrderVo.getUpdatedEndTime())){
            lambda.between(PurchaseOrder::getContractSignDate,purchaseOrderVo.getContractSignStartDate(),purchaseOrderVo.getContractSignEndDate());
        }
        PageHelper.startPage(purchaseOrderVo.getPageNum(),purchaseOrderVo.getPageSize());
        List<PurchaseOrder> purchaseOrders = purchaseOrderMapper.selectList(queryWrapper);
        return new PageInfo<>(purchaseOrders);
    }

    @Override
    public void addPurchaseOrder(PurchaseOrder purchaseOrder) {
        purchaseOrderMapper.insert(purchaseOrder);
    }

    @Override
    public void batchAddPurchaseOrder(List<PurchaseOrder> purchaseOrders) {
        purchaseOrders.forEach(purchaseOrder -> purchaseOrderMapper.insert(purchaseOrder));
    }

}
