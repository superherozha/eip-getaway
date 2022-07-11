package com.cxist.eip.gateway.service.impl;

import com.cxist.eip.gateway.dao.PurchaseSalesRelMapper;
import com.cxist.eip.gateway.entity.PurchaseSalesRel;
import com.cxist.eip.gateway.service.PurchaseSalesRelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther Chaos
 * @Date 2022/7/11
 * @Description: 采购订单行关联采购订单行项目维护服务
 */
@Service
public class PurchaseSalesRelServiceImpl implements PurchaseSalesRelService {
    @Resource
    PurchaseSalesRelMapper purchaseSalesRelMapper;

    @Override
    public void purchaseSalesRel(PurchaseSalesRel purchaseSalesRel) {
        purchaseSalesRelMapper.insert(purchaseSalesRel);
    }

    @Override
    public void batchSave(List<PurchaseSalesRel> purchaseSalesRels) {
        purchaseSalesRels.forEach(purchaseSalesRel -> purchaseSalesRelMapper.insert(purchaseSalesRel));
    }

    @Override
    public void updateMapping(PurchaseSalesRel purchaseSalesRel) {
        purchaseSalesRelMapper.updateById(purchaseSalesRel);
    }
}
