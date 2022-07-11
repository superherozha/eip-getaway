package com.cxist.eip.gateway.service;

import com.cxist.eip.gateway.entity.ProductEntityInfo;
/**
 * @Auther Chaos
 * @Date 2022/7/8
 */
public interface EntityInfoService {

    void add(ProductEntityInfo entityInfo);

    void modify(ProductEntityInfo entityInfo);
}
