package com.cxist.eip.gateway.service.impl;

import com.cxist.eip.gateway.dao.TestStepMapper;
import com.cxist.eip.gateway.entity.TestStep;
import com.cxist.eip.gateway.service.TestStepService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 */
@Service
public class TestStepServiceImpl implements TestStepService {
    @Resource
    TestStepMapper testStepMapper;

    @Override
    public void add(TestStep testStep) {
        testStepMapper.insert(testStep);
    }
}
