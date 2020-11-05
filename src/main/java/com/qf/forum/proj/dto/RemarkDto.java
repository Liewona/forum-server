package com.qf.forum.proj.dto;
/*
 *   Author = Liewona
 *   Date = 2020/11/5 16:00
 */

import com.qf.forum.proj.entity.Remark;

public class RemarkDto extends Remark {

    private String uname;
    private String img;

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
        return "RemarkDto{" +
                "uname='" + uname + '\'' +
                ", img='" + img + '\'' +
                ", id=" + id +
                ", did=" + did +
                ", content='" + content + '\'' +
                ", createTime='" + createTime + '\'' +
                ", uid=" + uid +
                '}';
    }
}
