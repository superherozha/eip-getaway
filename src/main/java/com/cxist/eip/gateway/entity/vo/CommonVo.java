package com.cxist.eip.gateway.entity.vo;

import lombok.Data;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 */
@Data
public class CommonVo {
    private Integer pageNum;
    private Integer pageSize;
    private String updatedStartTime;
    private String updatedEndTime;
    private String contractSignStartDate;
    private String contractSignEndDate;
}
