package com.cxist.eip.gateway.service.impl;

import com.cxist.eip.gateway.dao.EntityInfoMapper;
import com.cxist.eip.gateway.entity.ProductEntityInfo;
import com.cxist.eip.gateway.service.EntityInfoService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 * @Description: 实体服务
 */
@Service
public class EntityInfoServiceImpl implements EntityInfoService {

    @Resource
    EntityInfoMapper entityInfoMapper;

    @Override
    public void add(ProductEntityInfo entityInfo) {
        entityInfoMapper.insert(entityInfo);
    }

    @Override
    public void modify(ProductEntityInfo entityInfo) {
        entityInfoMapper.updateById(entityInfo);
    }
}
