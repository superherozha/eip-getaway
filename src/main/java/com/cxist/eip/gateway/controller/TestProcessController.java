package com.cxist.eip.gateway.controller;

import com.cxist.eip.gateway.common.ResponseResult;
import com.cxist.eip.gateway.common.StatusEnum;
import com.cxist.eip.gateway.entity.TestCondition;
import com.cxist.eip.gateway.entity.TestProcess;
import com.cxist.eip.gateway.service.TestConditionService;
import com.cxist.eip.gateway.service.TestProcessService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

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

    @RequestMapping(value = "/add")
    public ResponseResult<Object> add(TestProcess testProcess){
        try {
            testProcessService.add(testProcess);
            TestCondition testCondition = testProcess.getTestCondition();
            testCondition.setTestNo(testProcess.getTestNo());
            testConditionService.add(testCondition);
            return new ResponseResult<>(true, StatusEnum.OK,testProcess.getId());
        }catch (Exception e){
            return new ResponseResult<>(false, StatusEnum.ERROR,e.getMessage());
        }
    }

    @RequestMapping(value = "/updateResult")
    public ResponseResult<Object> updateResult(@RequestBody TestProcess testProcess){
        try {
            testProcessService.updateResult(testProcess);
            return new ResponseResult<>(true, StatusEnum.OK);
        }catch (Exception e){
            return new ResponseResult<>(false, StatusEnum.ERROR,e.getMessage());
        }
    }

}
