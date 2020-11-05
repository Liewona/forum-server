package com.qf.forum.proj.dto;

import com.qf.forum.proj.entity.Remark;

public class CommentDto extends Remark {
    protected String uname;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
