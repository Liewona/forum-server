package com.qf.forum.proj.controller;
/*
 *   Author = Liewona
 *   Date = 2020/11/1 14:57
 */

import com.alibaba.fastjson.JSONObject;
import com.qf.forum.config.aspect.annotation.LoginCheck;
import com.qf.forum.proj.dto.DiscussDto;
import com.qf.forum.proj.entity.Account;
import com.qf.forum.proj.entity.Discuss;
import com.qf.forum.proj.entity.UserAccount;
import com.qf.forum.proj.result.Result;
import com.qf.forum.proj.result.ResultData;
import com.qf.forum.proj.service.DiscussService;
import com.qf.forum.utils.DiscussQuery;
import com.qf.forum.utils.ResultEnum;
import com.qf.forum.utils.StringUtils;
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
     * @return
     */
    @GetMapping
    public Result selectDiscuss(DiscussQuery query) {
        System.out.println(query);
        if(query.getPage() <= 0) {
            query.setPage(1);
        }
        if(query.getLimit() <= 0) {
            query.setLimit(10);
        }
        query.update();
        List<DiscussDto> discussDtoList = discussService.selectDiscuss(query);
        int count = discussService.selectCount();
        return new ResultData(ResultEnum.SUCCESS, discussDtoList, (long) count);
    }

    /**
     * 增加帖子
     * @param body
     * @return
     */
    @LoginCheck
    @PostMapping
    public Result addDiscuss(@RequestBody JSONObject body, HttpServletRequest request) {
        Result rst = new Result();

//        UserAccount account = (UserAccount) request.getSession().getAttribute(StringUtils.SESSION_KEY);
//        int uid = account.getUid();
        int uid = body.getIntValue("id");
        String content = body.getString("content");
        String title = body.getString("title");
        Discuss discuss = new Discuss(title, content, uid);
        discussService.addDiscuss(rst, discuss);
        return rst.getCode() == null ? new Result(ResultEnum.UNKNOWN) : rst;
    }


    @GetMapping("/{id}")
    public Result selectById(@PathVariable("id") int id) {
        Discuss discuss =  discussService.selectById(id);
        return new ResultData(ResultEnum.SUCCESS, discuss);
    }
}
