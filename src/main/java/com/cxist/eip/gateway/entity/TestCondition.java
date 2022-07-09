package com.cxist.eip.gateway.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 */
@Data
public class TestCondition {
    private Integer id;
    private String testNo;
    private String testProjectType;
    private String gasPressure;
    private String itemCode;
    private String phaseConductorName;
    private String actionType;
    private String wiringType;
    private String polarity;
    private String standardVoltage;
    private Date backgroudInterference;
    private String createdTime;
    private Date updatedTime;
    private char isDeleted;
}
