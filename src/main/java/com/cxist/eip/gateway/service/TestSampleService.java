package com.cxist.eip.gateway.service;

import com.cxist.eip.gateway.entity.TestSample;

import java.util.List;

/**
 * @Auther Chaos
 * @Date 2022/7/11
 */
public interface TestSampleService {
    void add(TestSample testSample);

    void batchAdd(List<TestSample> testSamples);
}
