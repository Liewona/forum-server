package com.qf.forum.proj.dto;

import com.qf.forum.proj.entity.UserAccount;

public class UserDto extends UserAccount {

    protected String uname;

    protected String phone;

    protected String registerTime;
    protected Integer age;
    protected String sex;
    protected String img;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "uname='" + uname + '\'' +
                ", phone='" + phone + '\'' +
                ", registerTime='" + registerTime + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}