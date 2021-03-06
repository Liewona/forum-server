package com.qf.forum.proj.dto;
/*
 *   Author = Liewona
 *   Date = 2020/11/1 14:54
 */

import com.qf.forum.proj.entity.Discuss;

public class DiscussDto extends Discuss {
    protected String uname;
    protected String img;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


    @Override
    public String toString() {
        return "DiscussDto{" +
                "uname='" + uname + '\'' +
                ", img='" + img + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createTime='" + createTime + '\'' +
                ", uid=" + uid +
                ", clickCount=" + clickCount +
                '}';
    }
}
