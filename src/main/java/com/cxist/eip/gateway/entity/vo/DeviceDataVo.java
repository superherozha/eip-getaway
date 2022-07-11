package com.cxist.eip.gateway.entity.vo;

import com.cxist.eip.gateway.entity.DeviceData;
import lombok.Data;

import java.util.Map;

/**
 * @Auther Chaos
 * @Date 2022/7/11
 */
@Data
public class DeviceDataVo extends DeviceData {
    private Map<String,Object> deviceData;
}
