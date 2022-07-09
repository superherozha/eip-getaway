package com.cxist.eip.gateway.controller;

import com.cxist.eip.gateway.common.ResponseResult;
import com.cxist.eip.gateway.common.StatusEnum;
import com.cxist.eip.gateway.entity.EntityInfo;
import com.cxist.eip.gateway.service.EntityInfoService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 */
@RestController
@CrossOrigin
@RequestMapping("/entityInfo")
public class EntityInfoController {
    @Resource
    EntityInfoService entityInfoService;

    @PostMapping("/add")
    public ResponseResult add(@RequestBody EntityInfo entityInfo){
        try {
            entityInfoService.save(entityInfo);
        }catch (Exception e){
            return new ResponseResult<>(false, StatusEnum.ERROR);
        }
        return new ResponseResult<>(true, StatusEnum.OK);
    }
}
