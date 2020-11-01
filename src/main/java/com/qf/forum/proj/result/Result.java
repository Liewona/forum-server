package com.qf.forum.proj.result;
/*
 *   Author = Liewona
 *   Date = 2020/11/1 17:03
 */

public class Result {
    protected String code;
    protected String msg;

    public Result() {
    }

    public Result(String code, String msg) {
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
