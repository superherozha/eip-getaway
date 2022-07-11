package com.cxist.eip.gateway.service;

import com.cxist.eip.gateway.entity.PurchaseSalesRel;

import java.util.List;

/**
 * @Auther Chaos
 * @Date 2022/7/11
 */
public interface PurchaseSalesRelService {
    void purchaseSalesRel(PurchaseSalesRel purchaseSalesRel);

    void batchSave(List<PurchaseSalesRel> purchaseSalesRels);

    void updateMapping(PurchaseSalesRel purchaseSalesRel);
}
