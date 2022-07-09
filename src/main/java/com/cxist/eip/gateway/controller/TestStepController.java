package com.cxist.eip.gateway.controller;

import com.cxist.eip.gateway.common.ResponseResult;
import com.cxist.eip.gateway.common.StatusEnum;
import com.cxist.eip.gateway.entity.TestStep;
import com.cxist.eip.gateway.service.TestStepService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 * @Description: 试验步骤接口
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/testStep")
public class TestStepController {

    @Resource
    TestStepService testStepService;

    @RequestMapping(value = "/add")
    public ResponseResult<Object> add(@RequestBody TestStep testStep){
        try {
            testStepService.add(testStep);
            return new ResponseResult<>(true, StatusEnum.OK);
        }catch (Exception e){
            return new ResponseResult<>(false, StatusEnum.ERROR,e.getMessage());
        }
    }

}
