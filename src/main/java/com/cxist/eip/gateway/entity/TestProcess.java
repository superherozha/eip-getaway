package com.cxist.eip.gateway.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 */
@Data
public class TestProcess {
    private Integer id;
    private String testGroupNo;
    private String testNo;
    private String testDeviceCode;
    private String testStartTime;
    private String testOperator;
    private Date testEndTime;
    private String testResult;
    private String testResultDesc;
    private String testStatus;
    private Date createdTime;
    private Date updatedTime;
    private String isDeleted;
    private TestCondition testCondition;
    private TestResultDetail testResultDetail;
}
