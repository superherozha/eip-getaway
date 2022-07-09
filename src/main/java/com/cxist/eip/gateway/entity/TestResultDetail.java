package com.cxist.eip.gateway.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 */
@Data
public class TestResultDetail {
    private Integer id;
    private String testProjectType;
    private BigDecimal route;
    private BigDecimal openDistance;
    private BigDecimal overDistance;
    private Date close_time;
    private Date closeAsynchronousTime;
    private BigDecimal closeRoute;
    private BigDecimal closeSpeed;
    private BigDecimal openRoute;
    private BigDecimal openSpeed;
    private Long openAsynchronousTime;
    private Date openTime2;
    private Date openDifferenceTime;
    private Long closeOpenTime;
    private BigDecimal actualVoltage;
    private BigDecimal actualDischargeCapacity;
    private BigDecimal electricStrengthDuration;
    private BigDecimal partialDischargeDuration;
    private Date createdTime;
    private Date updatedTime;
    private char isDeleted;
}
