package com.qf.forum.proj.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.qf.forum.proj.entity.TbDiscuss;

public class TbDiscussDto extends TbDiscuss {

    @TableField("UNAME")
    private String uname;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Override
    public String toString() {
        return super.toString()+",uname:"+uname;
    }
}
