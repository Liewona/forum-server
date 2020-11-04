package com.qf.forum.proj.controller;
/*
 *   Author = Liewona
 *   Date = 2020/11/3 17:38
 */

import com.alibaba.fastjson.JSONObject;
import com.qf.forum.proj.entity.Remark;
import com.qf.forum.proj.result.Result;
import com.qf.forum.proj.result.ResultData;
import com.qf.forum.proj.service.RemarkService;
import com.qf.forum.utils.CommUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RequestMapping("remark")
@RestController
public class RemarkController {

    @Autowired
    private RemarkService remarkService;


    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @PostMapping
    public Result addRemark(@RequestBody Remark remark) {
        Result rst = new Result();
        remark.setCreateTime(CommUtil.getNowDateTime());
        remarkService.addRemark(rst, remark);


        redisTemplate.opsForValue().set("xjs", "hsahhahfahf需及时发给");

        return rst;
    }


    @PostMapping("/test")
    public Result testRemark(@RequestBody Remark remark) {
        Result rst = new Result();
        remark.setCreateTime(CommUtil.getNowDateTime());
//        remarkService.addRemark(rst, remark);


        redisTemplate.opsForValue().set("xjs", remark);

        return new ResultData("123", "asd", remark);
    }
}
