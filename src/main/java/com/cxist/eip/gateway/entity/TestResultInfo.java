package com.cxist.eip.gateway.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 */
@Data
public class TestResultInfo {
    private Integer id;
    private String testNo;
    private Date testEndTime;
    private String testResult;
    private String testResultDesc;
    private String testStatus;
    private Date createdTime;
    private Date updatedTime;
    private char isDeleted;
}
