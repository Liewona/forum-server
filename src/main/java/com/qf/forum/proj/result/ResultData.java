package com.qf.forum.proj.result;
/*
 *   Author = Liewona
 *   Date = 2020/11/1 17:04
 */

public class ResultData extends Result {

    protected Object data;
    protected Long count;

    public ResultData() {

    }

    public ResultData(String code, String msg, Object data) {
        super(code, msg);
        this.data = data;
    }

    public ResultData(String code,String msg,Long count,Object data){
        super(code,msg);
        this.count = count;
        this.data = data;
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
