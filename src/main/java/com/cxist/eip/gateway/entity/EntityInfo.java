package com.cxist.eip.gateway.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 */
@Data
public class EntityInfo {
    private Integer id;
    private String entityId;
    private String entityDesc;
    private String productionOrderNo;
    private String productionSchedule;
    private String deliveryStatus;
    private String deliveryDate;
    private Date createdTime;
    private Date updatedTime;
    private char isDeleted;
}
