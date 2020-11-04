package com.qf.forum.proj.result;
/*
 *   Author = Liewona
 *   Date = 2020/11/3 11:20
 */

public class WangEditorResult extends ResultData {

    protected int errno;

    public WangEditorResult() {

    }

    public WangEditorResult(int errno) {
        this.errno = errno;
    }

    public WangEditorResult(int errno, Object data) {
        this.errno = errno;
        this.data = data;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }
}
