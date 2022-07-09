package com.cxist.eip.gateway.common;

import lombok.Data;

/**
 * 返回实体Bean
 * @Auther Chaos
 * @Date 2022/7/4
 */
@Data
public class ResponseResult<T> {

    private boolean flag;//是否成功

    private Integer code;//返回码

    private String message;// 返回消息

    private T data;//返回数据

    public ResponseResult(boolean flag, StatusEnum statusEnum, T data) {
        this.flag = flag;
        this.code = statusEnum.getCode();
        this.message = statusEnum.getDesc();
        this.data =  data;
    }

    public ResponseResult(boolean flag, StatusEnum statusEnum) {
        this.flag = flag;
        this.code = statusEnum.getCode();
        this.message = statusEnum.getDesc();
    }

    public ResponseResult() {
        this.flag = true;
        this.code = StatusEnum.OK.getCode();
        this.message = "操作成功!";
    }

}
