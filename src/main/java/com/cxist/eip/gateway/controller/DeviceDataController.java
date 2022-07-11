package com.cxist.eip.gateway.controller;

import com.alibaba.fastjson.JSON;
import com.cxist.eip.gateway.common.ResponseResult;
import com.cxist.eip.gateway.common.StatusEnum;
import com.cxist.eip.gateway.entity.DeviceData;
import com.cxist.eip.gateway.entity.TestDetailMetadata;
import com.cxist.eip.gateway.entity.vo.DeviceDataVo;
import com.cxist.eip.gateway.entity.vo.TagMetadataVo;
import com.cxist.eip.gateway.service.DeviceDataService;
import com.cxist.eip.gateway.service.TestDetailMetadataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther Chaos
 * @Date 2022/7/10
 * @Description: 设备自动采集接口
 */

@RestController
@CrossOrigin
@RequestMapping("/deviceData")
@Slf4j
public class DeviceDataController {
    @Resource
    DeviceDataService deviceDataService;

    @Resource
    TestDetailMetadataService testDetailMetadataService;

    @RequestMapping(value = "/add")
    public ResponseResult<Object> add(@RequestBody DeviceDataVo deviceDataVo){
        try {
            DeviceData deviceData = new DeviceData();
            BeanUtils.copyProperties(deviceDataVo,deviceData);
            Map<String, Object> deviceDataMap = deviceDataVo.getDeviceData();
            deviceData.setDeviceDatas(JSON.toJSONString(deviceDataMap));
            deviceDataService.add(deviceData);
        } catch (Exception e){
            return new ResponseResult<>(false, StatusEnum.ERROR,e.getMessage());
        }
        return new ResponseResult<>(true, StatusEnum.OK);
    }

    @RequestMapping(value = "batchAdd")
    public ResponseResult<Object> batchAdd(@RequestBody List<TagMetadataVo> tagMetadataVos){
        try {
            tagMetadataVos.forEach(tagMetadataVo -> {
                TestDetailMetadata testDetailMetadata = new TestDetailMetadata();
                BeanUtils.copyProperties(tagMetadataVo,testDetailMetadata);
                testDetailMetadataService.add(testDetailMetadata);
                List<DeviceDataVo> deviceDataVoList = tagMetadataVo.getDeviceDataList();
                List<DeviceData> deviceDataList = new ArrayList<>();
                deviceDataVoList.forEach(deviceDataVo -> {
                    DeviceData deviceData = new DeviceData();
                    BeanUtils.copyProperties(deviceDataVo,deviceData);
                    Map<String, Object> deviceDataMap = deviceDataVo.getDeviceData();
                    deviceData.setTestDetailMetadataId(testDetailMetadata.getId());
                    deviceData.setDeviceDatas(JSON.toJSONString(deviceDataMap));
                    deviceDataList.add(deviceData);
                });
                deviceDataService.batchAddDeviceData(deviceDataList);
            });
        } catch (Exception e){
            return new ResponseResult<>(false, StatusEnum.ERROR,e.getMessage());
        }
        return new ResponseResult<>(true, StatusEnum.OK);
    }
}
