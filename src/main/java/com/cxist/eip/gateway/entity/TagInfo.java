package com.cxist.eip.gateway.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 */
@Data
public class TagInfo {
    private Integer id;
    private String batchNo;
    private String deviceCode;
    private Date timestamp;
    private String deviceData;
    private Date createdTime;
    private Date updatedTime;
    private char isDeleted;
}
