package com.cxist.eip.gateway.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.cxist.eip.gateway.common.ResponseResult;
import com.cxist.eip.gateway.common.StatusEnum;
import com.cxist.eip.gateway.entity.TestGroup;
import com.cxist.eip.gateway.entity.TestSample;
import com.cxist.eip.gateway.entity.vo.TestGroupRequestVo;
import com.cxist.eip.gateway.service.TestGroupService;
import com.cxist.eip.gateway.service.TestSampleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
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
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/testGroup")
public class TestGroupController {

    @Resource
    TestGroupService testGroupService;

    @Resource
    TestSampleService testSampleService;

    /**
     * 测试组 新增
     * @param body 参数
     */
    @RequestMapping(value = "/add")
    public ResponseResult<Object> save(@RequestBody String body){
        try {
            TestGroupRequestVo testGroupRequestVo = JSON.parseObject(body, TestGroupRequestVo.class);
            TestGroup testGroup = new TestGroup();
            BeanUtils.copyProperties(testGroupRequestVo,testGroup);
            List<TestSample> sampleList = testGroupRequestVo.getSampleList();
            testGroupService.add(testGroup);
            if (CollectionUtils.isNotEmpty(sampleList)){
                sampleList.forEach(testSample -> testSample.setTestGroupId(testGroup.getTestGroupId()));
                testSampleService.batchAdd(sampleList);
            }
            Map<String, Object> map = new HashMap<>();
            map.put("testGroupId",testGroup.getTestGroupId());
            return new ResponseResult<>(true, StatusEnum.OK,map);
        }catch (Exception e){
            return new ResponseResult<>(false, StatusEnum.ERROR,e.getMessage());
        }
    }

    /**
     * 测试组修改
     * @param testGroup 测试组对象
     */
    @RequestMapping(value = "/modify")
    public ResponseResult<Object> update(@RequestBody TestGroup testGroup){
        try {
            testGroupService.modify(testGroup);
            Map<String, Object> hashMap = new HashMap<>();
            hashMap.put("testGroupId",testGroup.getTestGroupId());
            hashMap.put("testGroupStatus",testGroup.getTestGroupStatus());
            return new ResponseResult<>(true, StatusEnum.OK, hashMap);
        }catch (Exception e){
            return new ResponseResult<>(false, StatusEnum.ERROR,e.getMessage());
        }
    }
}
