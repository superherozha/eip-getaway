package com.cxist.eip.gateway.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 */
@Data
public class TestStep {
    private Integer id;
    private String testNo;
    private String testStepIndex;
    private Date testStepTime;
    private String testStepDesc;
    private Date created_time;
    private Date updatedTime;
    private char isDeleted;
}
