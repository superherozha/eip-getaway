package com.cxist.eip.gateway.service;

import com.cxist.eip.gateway.entity.TestProcess;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 */
public interface TestProcessService {
    void add(TestProcess testProcess);

    void update(TestProcess testProcess);

    void updateResult(TestProcess testProcess);
}
