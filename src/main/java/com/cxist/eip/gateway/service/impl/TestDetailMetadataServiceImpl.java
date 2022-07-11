package com.cxist.eip.gateway.service.impl;

import com.cxist.eip.gateway.dao.TestDetailMetadataMapper;
import com.cxist.eip.gateway.entity.TestDetailMetadata;
import com.cxist.eip.gateway.service.TestDetailMetadataService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther Chaos
 * @Date 2022/7/11
 */
@Service
public class TestDetailMetadataServiceImpl implements TestDetailMetadataService {
    @Resource
    TestDetailMetadataMapper testDetailMetaDataMapper;

    @Override
    public void add(TestDetailMetadata testDetailMetaData) {
        testDetailMetaDataMapper.insert(testDetailMetaData);
    }

    @Override
    public void batchAdd(List<TestDetailMetadata> testDetailMetadataList) {
        testDetailMetadataList.forEach(testDetailMetaData -> testDetailMetaDataMapper.insert(testDetailMetaData));
    }
}
