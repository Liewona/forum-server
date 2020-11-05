package com.qf.forum.proj.dto;

import com.qf.forum.proj.entity.Account;

import java.util.List;

public class UserDto extends Account {

    protected List<DiscussDto> discussDtoList ;


    public List<DiscussDto> getDiscussDtoList() {
        return discussDtoList;
    }

    public void setDiscussDtoList(List<DiscussDto> discussDtoList) {
        this.discussDtoList = discussDtoList;
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
