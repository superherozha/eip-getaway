package com.cxist.eip.gateway.service;

import com.cxist.eip.gateway.entity.TestDetailMetadata;
import java.util.List;

/**
 * @Auther Chaos
 * @Date 2022/7/11
 */
public interface TestDetailMetadataService {
    void add(TestDetailMetadata testDetailMetadata);

    void batchAdd(List<TestDetailMetadata> testDetailMetaDataList);
}
