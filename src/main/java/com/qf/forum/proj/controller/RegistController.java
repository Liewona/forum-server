package com.qf.forum.proj.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.qf.forum.proj.dto.UserDto;
import com.qf.forum.proj.entity.Manager;
import com.qf.forum.proj.entity.UserAccount;
import com.qf.forum.proj.result.Result;
import com.qf.forum.proj.result.ResultData;
import com.qf.forum.proj.service.ManagerService;
import com.qf.forum.proj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/regist")
public class RegistController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public Result managerRegist(@RequestBody UserDto userDto){
        boolean flag = userService.registe(userDto);
        if (flag)
            return new Result("200","注册成功");
        return new Result("000","该用户已存在");
    }


}
