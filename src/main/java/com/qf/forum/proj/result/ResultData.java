package com.qf.forum.proj.result;
/*
 *   Author = Liewona
 *   Date = 2020/11/1 17:04
 */

public class ResultData extends Result {

    protected Object data;

    public ResultData() {

    }

    public ResultData(String code, String msg, Object data) {
        super(code, msg);
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
