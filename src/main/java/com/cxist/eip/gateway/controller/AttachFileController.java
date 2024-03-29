package com.cxist.eip.gateway.controller;

import com.cxist.eip.gateway.common.ResponseResult;
import com.cxist.eip.gateway.common.StatusEnum;
import com.cxist.eip.gateway.entity.AttachFile;
import com.cxist.eip.gateway.service.AttachFileService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
@RequestMapping("/attachFile")
public class AttachFileController {

    @Resource
    AttachFileService attachFileService;

    @GetMapping(value = "/search/{page}/{size}" )
    public ResponseResult<Object> findPage(@PathVariable int page, @PathVariable  int size){
        try {
            List<AttachFile> attachFiles = attachFileService.findPage(page, size);
            return new ResponseResult<>(true, StatusEnum.OK,attachFiles);
        }catch (Exception e){
            return new ResponseResult<>(false, StatusEnum.ERROR,e.getMessage());
        }
    }

    @PostMapping(value = "/upload")
    public ResponseResult<Object> upload(@RequestBody AttachFile attachFile){
        try {
            attachFileService.addAttachFile(attachFile);
            Map<String, Object> map = new HashMap<>();
            map.put("fileId",attachFile.getId());
            return new ResponseResult<>(true, StatusEnum.OK,map);
        }catch (Exception e){
            return new ResponseResult<>(false, StatusEnum.ERROR,e.getMessage());
        }
    }
}
