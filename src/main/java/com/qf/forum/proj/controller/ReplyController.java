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
import org.springframework.web.bind.annotation.*;

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


    @PostMapping
    public Result addReply(@RequestBody Reply reply) {
        int row = replyService.addReply(reply);
        if(row <= 0) {
            return new Result(ResultEnum.ERROR);
        }
        return new Result(ResultEnum.SUCCESS);
    }

}
