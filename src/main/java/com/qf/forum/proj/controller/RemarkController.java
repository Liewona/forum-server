package com.qf.forum.proj.controller;
/*
 *   Author = Liewona
 *   Date = 2020/11/3 17:38
 */

import com.alibaba.fastjson.JSONObject;
import com.qf.forum.config.aspect.annotation.LoginCheck;
import com.qf.forum.proj.entity.Account;
import com.qf.forum.proj.entity.Remark;
import com.qf.forum.proj.result.Result;
import com.qf.forum.proj.result.ResultData;
import com.qf.forum.proj.service.RemarkService;
import com.qf.forum.utils.CommUtil;
import com.qf.forum.utils.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("remark")
@RestController
public class RemarkController {

    @Autowired
    private RemarkService remarkService;


    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @PostMapping
    public Result addRemark(@RequestBody Remark remark, HttpServletRequest request) {
        Result rst = new Result();
        remark.setCreateTime(CommUtil.getNowDateTime());
        Account account = (Account) request.getSession().getAttribute("uaccount");
//        remark.setUid(account.getUid());  // 登陆模块写后开放
        remarkService.addRemark(rst, remark);
        return rst;
    }

    @GetMapping("/{uid}")
    public Result selectByUid(@PathVariable("uid") int uid) {
        Result rst = null;

        List<Remark> remarkList = remarkService.selectByUid(uid);

        return rst;
    }

    @GetMapping("/{id}")
    public Result selectById(@PathVariable("id") int id) {
        Result rst = null;

//        remarkService.selectById(id);

        return rst;
    }


//    @LoginCheck
    @PostMapping("/test")
    @Cacheable(value = "remark", key = "#remark.uid")
    public Result testRemark(@RequestBody Remark remark) {
        Result rst = new Result();
        remark.setCreateTime(CommUtil.getNowDateTime());
//        remarkService.addRemark(rst, remark);


        redisTemplate.opsForValue().set("xjs", remark);

        return new ResultData("123", "asd", remark);
    }


}
