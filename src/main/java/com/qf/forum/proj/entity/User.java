package com.qf.forum.proj.entity;
/*
 *   Author = Liewona
 *   Date = 2020/11/3 22:19
 */

public class User {
    private int id;
    protected String uname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
