package com.qf.forum.proj.controller;
/*
 *   Author = Liewona
 *   Date = 2020/11/5 0:55
 */

import com.qf.forum.proj.entity.Reply;
import com.qf.forum.proj.result.Result;
import com.qf.forum.proj.result.ResultData;
import com.qf.forum.proj.service.ReplyService;
import com.qf.forum.utils.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("reply")
@RestController
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @GetMapping("/{rid}")
    public Result selectByRid(@PathVariable("rid") int rid) {
        List<Reply> replies = replyService.selectByRid(rid);
        return new ResultData(ResultEnum.SUCCESS, replies);
    }

}
