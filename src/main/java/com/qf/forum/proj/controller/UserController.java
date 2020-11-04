package com.qf.forum.proj.controller;

import com.qf.forum.config.aspect.annotation.LoginCheck;
import com.qf.forum.proj.dto.UserDto;
import com.qf.forum.proj.dto.UserEditDto;
import com.qf.forum.proj.result.ResultData;
import com.qf.forum.proj.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Repeatable;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @LoginCheck
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ResultData getUserList(HttpServletRequest request, Integer page, Integer limit){
        return userService.getUserList(page,limit);
    }

    @LoginCheck
    @RequestMapping(value = "/like",method = RequestMethod.GET)
    public ResultData getUserListLike(HttpServletRequest request,String uname,String phone,Integer page,Integer limit){
        return userService.like(uname,phone,page,limit);
    }

    @LoginCheck
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResultData addUser(HttpServletRequest request,@RequestBody UserDto userDto){
        System.out.println(userDto.getUsername());
        boolean flag = userService.registe(userDto);
        if (flag){
            return new ResultData("200","新增成功",null);
        }
        return new ResultData("000","新增失败",null);
    }

    @LoginCheck
    @RequestMapping(value = "/",method = RequestMethod.DELETE)
    public ResultData deleteUser(HttpServletRequest request,@RequestBody String[] ids){
        for(String id:ids){
            userService.delete(id);
        }
        return new ResultData("200","删除成功",null);

    }

    @LoginCheck
    @RequestMapping(value = "/",method = RequestMethod.PATCH)
    public ResultData updateUser(HttpServletRequest request,@RequestBody UserEditDto userEditDto){
        return userService.update(userEditDto);
    }

    @LoginCheck
    @RequestMapping(value = "/twoCondition",method = RequestMethod.PATCH)
    public ResultData updateByTwo(HttpServletRequest request,@RequestBody UserDto userDto){
        return userService.updateByTwo(userDto);
    }

}
