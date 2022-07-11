package com.cxist.eip.gateway.controller;

import com.alibaba.fastjson.JSON;
import com.cxist.eip.gateway.common.ResponseResult;
import com.cxist.eip.gateway.common.StatusEnum;
import com.cxist.eip.gateway.entity.TestCondition;
import com.cxist.eip.gateway.entity.TestDetailMetadata;
import com.cxist.eip.gateway.entity.TestProcess;
import com.cxist.eip.gateway.entity.vo.TestProcessRequestVo;
import com.cxist.eip.gateway.service.TestConditionService;
import com.cxist.eip.gateway.service.TestDetailMetadataService;
import com.cxist.eip.gateway.service.TestProcessService;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 * @Description: 试验过程
 */

@RestController
@CrossOrigin
@RequestMapping(value = "/testProcess")
public class TestProcessController {
    @Resource
    TestProcessService testProcessService;

    @Resource
    TestConditionService testConditionService;

    @Resource
    TestDetailMetadataService testDetailMetadataService;

    /**
     * 试验过程新增
     * @param body 参数
     */
    @RequestMapping(value = "/add")
    public ResponseResult<Object> add(@RequestBody String body){
        try {
            TestProcessRequestVo testProcessRequestVo = JSON.parseObject(body, TestProcessRequestVo.class);
            TestProcess testProcess = new TestProcess();
            BeanUtils.copyProperties(testProcessRequestVo,testProcess);
            testProcessService.add(testProcess);
            TestCondition testCondition = testProcessRequestVo.getTestCondition();
            testCondition.setTestNo(testProcess.getTestNo());
            testConditionService.add(testCondition);
            Map<String, Object> map = new HashMap<>();
            map.put("testId",testProcess.getTestId());
            return new ResponseResult<>(true, StatusEnum.OK,map);
        }catch (Exception e){
            return new ResponseResult<>(false, StatusEnum.ERROR,e.getMessage());
        }
    }

    /**
     * 试验结果修改
     * @param testProcessRequestVo 试验结果参数
     */
    @Transactional
    @RequestMapping(value = "/updateResult")
    public ResponseResult<Object> updateResult(@RequestBody TestProcessRequestVo testProcessRequestVo){
        try {
            TestProcess testProcess = new TestProcess();
            BeanUtils.copyProperties(testProcessRequestVo,testProcess);
            testProcessService.updateResult(testProcess);
            List<TestDetailMetadata> testDetailMetadataList = testProcessRequestVo.getTestDetailMetadataList();
            testDetailMetadataService.batchAdd(testDetailMetadataList);
            return new ResponseResult<>(true, StatusEnum.OK);
        }catch (Exception e){
            return new ResponseResult<>(false, StatusEnum.ERROR,e.getMessage());
        }
    }

}
