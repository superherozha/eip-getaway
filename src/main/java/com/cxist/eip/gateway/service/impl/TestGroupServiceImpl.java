package com.cxist.eip.gateway.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cxist.eip.gateway.dao.TestGroupMapper;
import com.cxist.eip.gateway.entity.TestGroup;
import com.cxist.eip.gateway.service.TestGroupService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 * @Description: 测试组服务
 */
@Service
public class TestGroupServiceImpl implements TestGroupService {

    @Resource
    TestGroupMapper testGroupMapper;

    @Override
    public void add(TestGroup testGroup) {
        testGroupMapper.insert(testGroup);
    }

    @Override
    public void modify(TestGroup testGroup){
        testGroupMapper.updateById(testGroup);
    }

    @Override
    public void modifyByNo(TestGroup testGroup){
        UpdateWrapper<TestGroup> wrapper = new UpdateWrapper<>();
        testGroupMapper.update(testGroup,wrapper.lambda().ge(TestGroup::getTestGroupNo,testGroup.getTestGroupNo()));
    }
}
