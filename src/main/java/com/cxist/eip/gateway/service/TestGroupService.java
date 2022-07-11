package com.cxist.eip.gateway.service;

import com.cxist.eip.gateway.entity.TestGroup;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 */
public interface TestGroupService {
    void add(TestGroup testGroup);

    void modify(TestGroup testGroup);

    void modifyByNo(TestGroup testGroup);
}
