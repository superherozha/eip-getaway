package com.cxist.eip.gateway.service;

import com.cxist.eip.gateway.entity.DeviceData;
import java.util.List;

/**
 * @Auther Chaos
 * @Date 2022/7/10
 */
public interface DeviceDataService {
    void add(DeviceData tagInfo);

    void batchAddDeviceData(List<DeviceData> deviceDataList);
}
