package com.cxist.eip.gateway.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther Chaos
 * @Date 2022/7/8
 */
public enum StatusEnum {

    OK(200, "成功"), ERROR(-100, "失败");

    private final Integer code;
    private final String desc;

    private StatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    protected static final Map<Integer, StatusEnum> MAP = new HashMap<>();

    static {
        for (StatusEnum statusEnum : StatusEnum.values()) {
            MAP.put(statusEnum.getCode(), statusEnum);
        }
    }

    public static StatusEnum getByCode(Integer status) {
        return MAP.getOrDefault(status, null);
    }

}
