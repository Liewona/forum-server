package com.qf.forum.proj.entity;
/*
 *   Author = Liewona
 *   Date = 2020/11/3 22:18
 */

public class Account extends User {

    private int id;
    protected int uid;
    protected String username;
    protected String password;


    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
