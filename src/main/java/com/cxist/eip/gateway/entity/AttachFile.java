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
public class AttachFile {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String fileNo;
    private String fileUrl;
    @TableField(value = "gmt_created",fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT")
    private Date gmtCreated;
    @TableField(value = "gmt_updated",fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT")
    private Date gmtUpdated;
    @TableField(value = "is_deleted",fill = FieldFill.INSERT)
    private char isDeleted;
}
