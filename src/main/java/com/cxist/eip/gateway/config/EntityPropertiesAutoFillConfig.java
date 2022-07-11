package com.cxist.eip.gateway.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * @Auther Chaos
 * @Date 2022/7/10
 */
@Configuration
public class EntityPropertiesAutoFillConfig implements MetaObjectHandler {
    /**
     * @param metaObject 参数
     * @method 插入时自动填充
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("gmtCreated", new Date(), metaObject);
        this.setFieldValByName("isDeleted", 'N', metaObject);
        this.setFieldValByName("lineNumber", 1, metaObject);
        this.setFieldValByName("sampleNum", 1, metaObject);
        this.setFieldValByName("testStepIndex", 1, metaObject);
        this.setFieldValByName("deliveryStatus", "00", metaObject);
    }

    /**
     * @param metaObject 参数
     * @method 更新时自动填充
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("gmtUpdated", new Date(), metaObject);
    }
}
