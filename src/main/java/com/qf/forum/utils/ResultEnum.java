package com.qf.forum.utils;
/*
 *   Author = Liewona
 *   Date = 2020/11/3 16:32
 */

public enum ResultEnum {


    SUCCESS("0000", "success"),
    ERROR("0001", "error"),
    UNKNOWN("9999", "unknown error");


    private String code;
    private String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
