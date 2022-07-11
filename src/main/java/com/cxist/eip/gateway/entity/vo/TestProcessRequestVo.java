package com.cxist.eip.gateway.entity.vo;

import com.cxist.eip.gateway.entity.TestCondition;
import com.cxist.eip.gateway.entity.TestDetailMetadata;
import com.cxist.eip.gateway.entity.TestProcess;
import com.cxist.eip.gateway.entity.TestResultDetail;
import lombok.Data;

import java.util.List;

/**
 * @Auther Chaos
 * @Date 2022/7/10
 */
@Data
public class TestProcessRequestVo extends TestProcess {
    private TestCondition testCondition;
    private TestResultDetail testResultDetail;
    private List<TestDetailMetadata> testDetailMetadataList;
}
