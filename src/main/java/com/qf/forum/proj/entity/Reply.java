package com.qf.forum.proj.entity;
/*
 *   Author = Liewona
 *   Date = 2020/11/5 0:55
 */

public class Reply {
    private int id;
    private int fromId;
    private int toId;
    private String content;
    private String createTime;
    private int remarkId;

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", fromId=" + fromId +
                ", toId=" + toId +
                ", content='" + content + '\'' +
                ", createTime='" + createTime + '\'' +
                ", remarkId=" + remarkId +
                '}';
    }

    public int getFromId() {
        return fromId;
    }

    public void setFromId(int fromId) {
        this.fromId = fromId;
    }

    public int getToId() {
        return toId;
    }

    public void setToId(int toId) {
        this.toId = toId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getRemarkId() {
        return remarkId;
    }

    public void setRemarkId(int remarkId) {
        this.remarkId = remarkId;
    }
}
