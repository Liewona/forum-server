package com.qf.forum.proj.controller;

import com.qf.forum.config.aspect.annotation.LoginCheck;
import com.qf.forum.proj.dto.EditDto;
import com.qf.forum.proj.result.ResultData;
import com.qf.forum.proj.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/comment")
@RestController
public class commentController {

    @Autowired
    private CommentService commentService;

    @LoginCheck
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ResultData getCommentList(HttpServletRequest request,Integer page, Integer limit){
        return commentService.getCommentList(page,limit);
    }

    @LoginCheck
    @RequestMapping(value = "/like",method = RequestMethod.GET)
    public ResultData like(HttpServletRequest request,String content,Integer page,Integer limit){
        return commentService.like(content,page,limit);
    }

    @LoginCheck
    @RequestMapping(value = "/",method = RequestMethod.DELETE)
    public ResultData deleteUser(HttpServletRequest request,@RequestBody String[] ids){
        for(String id:ids){
//            commentService.delete(id);
        }
        return new ResultData("200","删除成功",null);
    }

    @LoginCheck
    @RequestMapping(value = "/" ,method = RequestMethod.PATCH)
    public ResultData update(HttpServletRequest request,@RequestBody EditDto editDto){
        return commentService.update(editDto);
    }

    @LoginCheck
    @RequestMapping(value = "/time" ,method = RequestMethod.GET)
    public ResultData searchByTime(HttpServletRequest request,String time,Integer page,Integer limit){
        System.out.println(time);
        return commentService.searchByTime(time,page,limit);
    }
}
