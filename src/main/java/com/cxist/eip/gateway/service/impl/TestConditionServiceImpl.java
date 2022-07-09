package com.cxist.eip.gateway.service.impl;

import com.cxist.eip.gateway.dao.TestConditionMapper;
import com.cxist.eip.gateway.entity.TestCondition;
import com.cxist.eip.gateway.service.TestConditionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 * @Description: 试验条件服务
 */
@Service
public class TestConditionServiceImpl implements TestConditionService {

    @Resource
    TestConditionMapper testConditionMapper;

    @Override
    public void add(TestCondition testCondition) {
        testConditionMapper.insert(testCondition);
    }

    @Override
    public void update(TestCondition testCondition) {
        testConditionMapper.updateById(testCondition);
    }
}
