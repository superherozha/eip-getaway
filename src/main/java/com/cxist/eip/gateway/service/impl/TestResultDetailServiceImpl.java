package com.cxist.eip.gateway.service.impl;

import com.cxist.eip.gateway.dao.TestResultDetailMapper;
import com.cxist.eip.gateway.entity.TestResultDetail;
import com.cxist.eip.gateway.service.TestResultDetailService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @Auther Chaos
 * @Date 2022/7/11
 */
@Service
public class TestResultDetailServiceImpl implements TestResultDetailService {
    @Resource
    TestResultDetailMapper testResultDetailMapper;

    @Override
    public void add(TestResultDetail testResultDetail) {
        testResultDetailMapper.insert(testResultDetail);
    }
}
