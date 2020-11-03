package com.qf.forum.proj.controller;
/*
 *   Author = Liewona
 *   Date = 2020/11/3 17:38
 */

import com.alibaba.fastjson.JSONObject;
import com.qf.forum.proj.entity.Remark;
import com.qf.forum.proj.result.Result;
import com.qf.forum.proj.result.ResultData;
import com.qf.forum.utils.CommUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("remark")
@RestController
public class RemarkController {


    @PostMapping
    public Result addRemark(@RequestBody Remark remark) {
        remark.setCreateTime(CommUtil.getNowDateTime());

        return new ResultData("aa", "bb", remark);
    }
}
