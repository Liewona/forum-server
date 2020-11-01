package com.qf.forum.proj.dto;
/*
 *   Author = Liewona
 *   Date = 2020/11/1 14:54
 */

import com.qf.forum.proj.entity.Discuss;

public class DiscussDto extends Discuss {
    protected String uname;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Override
    public String toString() {
        return "DiscussDto{" +
                "uname='" + uname + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createTime='" + createTime + '\'' +
                ", uid=" + uid +
                ", clickCount=" + clickCount +
                '}';
    }
}
