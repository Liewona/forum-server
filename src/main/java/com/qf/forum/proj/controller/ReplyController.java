package com.qf.forum.proj.controller;
/*
 *   Author = Liewona
 *   Date = 2020/11/5 0:55
 */

import com.qf.forum.config.aspect.annotation.LoginCheck;
import com.qf.forum.proj.dto.EditDto;
import com.qf.forum.proj.entity.Reply;
import com.qf.forum.proj.result.Result;
import com.qf.forum.proj.result.ResultData;
import com.qf.forum.proj.service.ReplyService;
import com.qf.forum.utils.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    //@LoginCheck
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ResultData getReplyList(HttpServletRequest request, Integer id, Integer page, Integer limit){
        return replyService.getReplyList(id,page,limit);
    }

    //@LoginCheck
    @RequestMapping(value = "/like",method = RequestMethod.GET)
    public ResultData like(HttpServletRequest request,String content,Integer id,Integer page,Integer limit){
        return replyService.like(id,content,page,limit);
    }

    //@LoginCheck
    @RequestMapping(value = "/" ,method = RequestMethod.PATCH)
    public ResultData update(HttpServletRequest request,@RequestBody EditDto editDto){
        return replyService.update(editDto);
    }

    //@LoginCheck
    @RequestMapping(value = "/time" ,method = RequestMethod.GET)
    public ResultData searchByTime(HttpServletRequest request,String time,Integer id,Integer page,Integer limit){
        System.out.println(time);
        return replyService.searchByTime(id,time,page,limit);
    }

    //@LoginCheck
    @RequestMapping(value = "/",method = RequestMethod.DELETE)
    public Result delete(HttpServletRequest request, @RequestBody Integer[] ids){
           return replyService.delete(ids);
    }

}
