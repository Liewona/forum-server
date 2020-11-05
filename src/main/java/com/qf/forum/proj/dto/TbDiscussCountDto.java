package com.qf.forum.proj.dto;

import com.baomidou.mybatisplus.annotation.TableField;

public class TbDiscussCountDto {

    @TableField("count")
    private Integer count;



    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }


}
