package com.qf.forum.proj.controller;
/*
 *   Author = Liewona
 *   Date = 2020/11/1 14:57
 */

import com.alibaba.fastjson.JSONObject;
import com.qf.forum.proj.dto.DiscussDto;
import com.qf.forum.proj.entity.Account;
import com.qf.forum.proj.entity.Discuss;
import com.qf.forum.proj.result.Result;
import com.qf.forum.proj.result.ResultData;
import com.qf.forum.proj.service.DiscussService;
import com.qf.forum.utils.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RequestMapping("discuss")
@RestController
public class DiscussController {

    @Autowired
    private DiscussService discussService;

    /**
     * 分页查询所有帖子
     * @param page
     * @param limit
     * @return
     */
    @GetMapping
    public Result selectOnPage(Integer page, Integer limit) {
        if(page == null || page <= 0) {
            page = 1;
        }
        if(limit == null || limit <= 0) {
            limit = 10;
        }
        List<DiscussDto> discussDtoList = discussService.selectOnPage(page, limit);
        return new ResultData("0000", "success", discussDtoList);
    }

    /**
     * 增加帖子
     * @param body
     * @return
     */
    @PostMapping
    public Result addDiscuss(@RequestBody JSONObject body, HttpServletRequest request) {
        Result rst = new Result();

        Account account = (Account) request.getSession().getAttribute("uaccount");
        int uid = account.getUid();
        String content = body.getString("content");
        String title = body.getString("title");
        Discuss discuss = new Discuss(title, content, uid);
        discussService.addDiscuss(rst, discuss);
        return rst.getCode() == null ? new Result(ResultEnum.UNKNOWN) : rst;
    }

}
