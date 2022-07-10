package com.cxist.eip.gateway.service.impl;

import com.cxist.eip.gateway.dao.DeviceDataMapper;
import com.cxist.eip.gateway.entity.DeviceData;
import com.cxist.eip.gateway.service.DeviceDataService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther Chaos
 * @Date 2022/7/10
 * @Description: 设备自动采集服务
 */
@Service
public class DeviceDataServiceImpl implements DeviceDataService {

    @Resource
    DeviceDataMapper deviceDataMapper;

    @Override
    public void add(DeviceData deviceData) {
        deviceDataMapper.insert(deviceData);
    }

    @Override
    public void batchAddDeviceData(List<DeviceData> deviceDataList) {
        deviceDataList.forEach(deviceData -> deviceDataMapper.insert(deviceData));
    }
}
