package com.qf.forum.proj.entity;

public class Reply {
    private Integer id;
    protected Integer form;//回复人
    protected Integer to;//被回复人
    protected String content;
    protected String createTime;
    protected Integer remarkId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getForm() {
        return form;
    }

    public void setForm(Integer form) {
        this.form = form;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
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

    public Integer getRemarkId() {
        return remarkId;
    }

    public void setRemarkId(Integer remarkId) {
        this.remarkId = remarkId;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", form=" + form +
                ", to=" + to +
                ", content='" + content + '\'' +
                ", createTime='" + createTime + '\'' +
                ", remarkId=" + remarkId +
                '}';
    }
}
