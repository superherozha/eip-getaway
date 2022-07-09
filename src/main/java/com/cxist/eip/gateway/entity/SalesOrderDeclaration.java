package com.cxist.eip.gateway.entity;

import lombok.Data;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 */

@Data
public class SalesOrderDeclaration {
    private Integer id;
    private String salesOrderId;
    private String declaration;
    private String fileId;
}
