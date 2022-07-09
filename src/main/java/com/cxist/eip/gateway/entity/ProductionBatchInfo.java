package com.cxist.eip.gateway.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 */
@Data
public class ProductionBatchInfo {
    private Integer id;
    private String productionBatchNo;
    private String productionOrderNo;
    private String processCode;
    private String deviceCode;
    private String workshopCode;
    private String actualStartTime;
    private String actualEndTime;
    private Date createdTime;
    private Date updatedTime;
    private char isDeleted;
}
