package com.cxist.eip.gateway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cxist.eip.gateway.dao.TestProcessMapper;
import com.cxist.eip.gateway.entity.TestProcess;
import com.cxist.eip.gateway.service.TestProcessService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 * @Description: 测试过程服务
 */
@Service
public class TestProcessServiceImpl implements TestProcessService {

    @Resource
    TestProcessMapper testProcessMapper;

    @Override
    public void add(TestProcess testProcess) {
        testProcessMapper.insert(testProcess);
    }

    @Override
    public void update(TestProcess testProcess) {
        testProcessMapper.updateById(testProcess);
    }

    @Override
    public void updateResult(TestProcess testProcess) {
        testProcessMapper.updateById(testProcess);
    }
}
