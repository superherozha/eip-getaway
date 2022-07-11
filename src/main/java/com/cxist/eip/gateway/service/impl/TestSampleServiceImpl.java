package com.cxist.eip.gateway.service.impl;

import com.cxist.eip.gateway.dao.TestSampleMapper;
import com.cxist.eip.gateway.entity.TestSample;
import com.cxist.eip.gateway.service.TestSampleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther Chaos
 * @Date 2022/7/11
 */
@Service
public class TestSampleServiceImpl implements TestSampleService {
    @Resource
    TestSampleMapper testSampleMapper;

    @Override
    public void add(TestSample testSample) {
        testSampleMapper.insert(testSample);
    }

    @Override
    public void batchAdd(List<TestSample> testSamples) {
        testSamples.forEach(testSample -> testSampleMapper.insert(testSample));
    }
}
