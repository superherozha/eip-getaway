package com.cxist.eip.gateway.service.impl;

import com.cxist.eip.gateway.dao.EntityInfoMapper;
import com.cxist.eip.gateway.entity.EntityInfo;
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
    public void save(EntityInfo entityInfo) {
        if (entityInfo.getId() != null){
            entityInfoMapper.updateById(entityInfo);
        } else {
            entityInfoMapper.insert(entityInfo);
        }
    }
}
