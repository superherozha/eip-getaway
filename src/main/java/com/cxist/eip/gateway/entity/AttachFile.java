package com.cxist.eip.gateway.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 */
@Data
public class AttachFile {
    private Integer id;
    private String fileNo;
    private String fileUrl;
    private Date createdTime;
    private Date updatedTime;
    private char isDeleted;
}
