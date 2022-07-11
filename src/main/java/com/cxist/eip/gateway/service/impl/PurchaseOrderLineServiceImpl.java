package com.cxist.eip.gateway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.cxist.eip.gateway.dao.PurchaseOrderLineMapper;
import com.cxist.eip.gateway.entity.PurchaseOrderLine;
import com.cxist.eip.gateway.entity.vo.PurchaseOrderVo;
import com.cxist.eip.gateway.service.PurchaseOrderLineService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 * @Description: 采购订单行服务
 */
@Service
public class PurchaseOrderLineServiceImpl implements PurchaseOrderLineService {

    @Resource
    PurchaseOrderLineMapper purchaseOrderLineMapper;

    @Override
    public PageInfo<PurchaseOrderLine> getPagePurchaseOrderLine(PurchaseOrderVo purchaseOrderVo) {
        QueryWrapper<PurchaseOrderLine> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<PurchaseOrderLine> lambda = queryWrapper.lambda();
        lambda.eq(PurchaseOrderLine::getIsDeleted,"N");
        if (StringUtils.isNotBlank(purchaseOrderVo.getPurchaseOrderId())){
            lambda.eq(PurchaseOrderLine::getPurchaseOrderId, purchaseOrderVo.getPurchaseOrderId());
        }
        PageHelper.startPage(purchaseOrderVo.getPageNum(),purchaseOrderVo.getPageSize());
        List<PurchaseOrderLine> purchaseOrders = purchaseOrderLineMapper.selectList(queryWrapper);
        return new PageInfo<>(purchaseOrders);
    }

    @Override
    public void batchAddPurchaseOrderLine(List<PurchaseOrderLine> purchaseOrderLines) {
        purchaseOrderLines.forEach(purchaseOrderLine -> purchaseOrderLineMapper.insert(purchaseOrderLine));
    }
}
