package com.cxist.eip.gateway.entity.vo;

import com.cxist.eip.gateway.entity.DeviceData;
import com.cxist.eip.gateway.entity.TestDetailMetadata;
import lombok.Data;

import java.util.List;

/**
 * @Auther Chaos
 * @Date 2022/7/11
 */
@Data
public class TagMetadataVo extends TestDetailMetadata {
    private List<DeviceDataVo> deviceDataList;
}
