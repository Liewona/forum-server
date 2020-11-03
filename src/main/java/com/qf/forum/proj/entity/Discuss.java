package com.qf.forum.proj.entity;
/*
 *   Author = Liewona
 *   Date = 2020/11/1 14:19
 */

import com.qf.forum.utils.CommUtil;

public class Discuss {

    protected int id;
    protected String title;
    protected String content;
    protected String createTime;
    protected int uid;
    protected int clickCount;

    public Discuss() {
    }

    public Discuss(String title, String content, int uid) {
        this.title = title;
        this.content = content;
        this.uid = uid;
        this.createTime = CommUtil.getNowDateTime();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getClickCount() {
        return clickCount;
    }

    public void setClickCount(int clickCount) {
        this.clickCount = clickCount;
    }

    @Override
    public String toString() {
        return "Discuss{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createTime='" + createTime + '\'' +
                ", uid=" + uid +
                ", clickCount=" + clickCount +
                '}';
    }
}
