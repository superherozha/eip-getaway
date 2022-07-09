package com.cxist.eip.gateway.service;

import com.cxist.eip.gateway.entity.AttachFile;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 */
public interface AttachFileService {

    void addAttachFile(AttachFile attachFile);

    void updateAttachFile(AttachFile attachFile);

    AttachFile getAttachFile(AttachFile attachFile);

    AttachFile getAttachFileById(Integer id);

    List<AttachFile> getAttachFileList(AttachFile attachFile);

    List<AttachFile> findPage(Integer page,Integer pageSize);
}
