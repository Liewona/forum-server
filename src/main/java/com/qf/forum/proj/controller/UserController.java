package com.qf.forum.proj.controller;

import com.qf.forum.proj.result.ResultData;
import com.qf.forum.proj.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ResultData getUserList(Integer page,Integer limit){
        return userService.getUserList(page,limit);
    }


}
