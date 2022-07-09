package com.cxist.eip.gateway.controller;

import com.alibaba.fastjson.JSON;
import com.cxist.eip.gateway.common.ResponseResult;
import com.cxist.eip.gateway.common.StatusEnum;
import com.cxist.eip.gateway.entity.TestGroup;
import com.cxist.eip.gateway.service.TestGroupService;
import jdk.internal.net.http.common.Pair;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/testGroup")
public class TestGroupController {

    @Resource
    TestGroupService testGroupService;

    @RequestMapping(value = "/add")
    public ResponseResult<Object> save(@RequestBody TestGroup testGroup){
        try {
            testGroupService.add(testGroup);
            return new ResponseResult<>(true, StatusEnum.OK,testGroup.getId());
        }catch (Exception e){
            return new ResponseResult<>(false, StatusEnum.ERROR,e.getMessage());
        }
    }

    @RequestMapping(value = "/update")
    public ResponseResult<Object> update(@RequestBody TestGroup testGroup){
        try {
            testGroupService.update(testGroup);
            Pair<String,Object> pair= new Pair<>(testGroup.getTestGroupNo(),testGroup.getTestGroupStatus());
            return new ResponseResult<>(true, StatusEnum.OK, JSON.toJSONString(pair));
        }catch (Exception e){
            return new ResponseResult<>(false, StatusEnum.ERROR,e.getMessage());
        }
    }
}
