package com.cxist.eip.gateway.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 */
@Data
public class DeviceData {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String batchNo;
    private String deviceCode;
    private Integer testDetailMetadataId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date timestamp;
    @TableField(value = "device_data")
    private String deviceDatas;
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gmtCreated;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gmtUpdated;
    @TableField(fill = FieldFill.INSERT)
    private char isDeleted;
}
