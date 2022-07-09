package com.cxist.eip.gateway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cxist.eip.gateway.dao.AttachFileMapper;
import com.cxist.eip.gateway.entity.AttachFile;
import com.cxist.eip.gateway.service.AttachFileService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 * @Description: 附件服务
 */
@Service
public class AttachFileServiceImpl implements AttachFileService {

    @Resource
    AttachFileMapper attachFileMapper;

    @Override
    public void addAttachFile(AttachFile attachFile) {
        attachFileMapper.insert(attachFile);
    }

    @Override
    public void updateAttachFile(AttachFile attachFile) {
        attachFileMapper.updateById(attachFile);
    }

    @Override
    public AttachFile getAttachFile(AttachFile attachFile) {
        return attachFileMapper.selectOne(new QueryWrapper<>(attachFile));
    }

    @Override
    public AttachFile getAttachFileById(Integer id) {
        return attachFileMapper.selectById(id);
    }

    @Override
    public List<AttachFile> getAttachFileList(AttachFile attachFile){
        return attachFileMapper.selectList(new QueryWrapper<>(attachFile));
    }

    @Override
    public List<AttachFile> findPage(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<AttachFile> attachFileList = getAttachFileList(new AttachFile());
        PageInfo<AttachFile> pageInfo = new PageInfo<>(attachFileList);
        return pageInfo.getList();
    }
}
