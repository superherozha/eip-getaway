package com.cxist.eip.gateway.entity.vo;

import com.cxist.eip.gateway.entity.TestGroup;
import com.cxist.eip.gateway.entity.TestSample;
import lombok.Data;

import java.util.List;

/**
 * @Auther Chaos
 * @Date 2022/7/11
 */
@Data
public class TestGroupRequestVo extends TestGroup {
    private List<TestSample> sampleList;
}
