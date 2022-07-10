package com.cxist.eip.gateway.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cxist.eip.gateway.common.ResponseResult;
import com.cxist.eip.gateway.common.StatusEnum;
import com.cxist.eip.gateway.entity.DeviceData;
import com.cxist.eip.gateway.service.DeviceDataService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther Chaos
 * @Date 2022/7/10
 * @Description: 设备自动采集接口
 */

@RestController
@CrossOrigin
@RequestMapping("/deviceData")
public class DeviceDataController {
    @Resource
    DeviceDataService deviceDataService;

    @RequestMapping(value = "/add")
    public ResponseResult<Object> add(@RequestBody DeviceData deviceData){
        try {
            deviceDataService.add(deviceData);
        } catch (Exception e){
            return new ResponseResult<>(false, StatusEnum.ERROR);
        }
        return new ResponseResult<>(true, StatusEnum.OK);
    }

    @RequestMapping(value = "batchAdd")
    public ResponseResult<Object> batchAdd(@RequestBody String params){
        try {
            JSONObject jsonObject = JSON.parseObject(params);
            String batchNo = jsonObject.getString("BATCH_NO");
            List<DeviceData> deviceDataList = JSON.parseArray(JSON.toJSONString(jsonObject.getJSONObject("deviceDataList")), DeviceData.class);
            deviceDataList.forEach(deviceData -> deviceData.setBatchNo(batchNo));
            deviceDataService.batchAddDeviceData(deviceDataList);
        } catch (Exception e){
            return new ResponseResult<>(false, StatusEnum.ERROR);
        }
        return new ResponseResult<>(true, StatusEnum.OK);
    }
}
