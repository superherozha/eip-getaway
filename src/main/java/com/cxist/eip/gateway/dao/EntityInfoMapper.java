package com.cxist.eip.gateway.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cxist.eip.gateway.entity.ProductEntityInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 */
@Mapper
public interface EntityInfoMapper extends BaseMapper<ProductEntityInfo> {
}
