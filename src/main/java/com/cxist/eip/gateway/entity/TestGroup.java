package com.cxist.eip.gateway.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 */
@Data
public class TestGroup {
    private Integer id;
    private String testGroupNo;
    private String testProjectType;
    private String sampleNum;
    private String sampleUnit;
    private String testRoomCode;
    private String testStartTime;
    private String testEndTime;
    private String testGroupStatus;
    private Date createdTime;
    private Date updatedTime;
    private char isDeleted;
}
