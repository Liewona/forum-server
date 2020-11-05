package com.qf.forum.proj.dto;
/*
 *   Author = Liewona
 *   Date = 2020/11/5 19:56
 */

import com.qf.forum.proj.entity.Reply;

public class ReplyDto extends Reply {

    protected String fromName;
    protected String toName;
    protected String fromImg;

    @Override
    public String toString() {
        return "ReplyDto{" +
                "fromName='" + fromName + '\'' +
                ", toName='" + toName + '\'' +
                ", fromImg='" + fromImg + '\'' +
                ", id=" + id +
                ", fromId=" + fromId +
                ", toId=" + toId +
                ", content='" + content + '\'' +
                ", createTime='" + createTime + '\'' +
                ", remarkId=" + remarkId +
                '}';
    }

    public String getFromImg() {
        return fromImg;
    }

    public void setFromImg(String fromImg) {
        this.fromImg = fromImg;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }
}
