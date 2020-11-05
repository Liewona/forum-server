package com.qf.forum.proj.entity;
/*
 *   Author = Liewona
 *   Date = 2020/11/3 17:38
 */

import com.qf.forum.utils.CommUtil;

public class Remark {

    protected int id;
    protected int did;
    protected String content;
    protected String createTime;
    protected int uid;

    public Remark() {

    }

    public Remark(int did, int uid, String content) {
        this.createTime = CommUtil.getNowDateTime();
        this.uid = uid;
        this.did = did;
        this.content = content;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
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
}
