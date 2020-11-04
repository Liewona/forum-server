package com.qf.forum.proj.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.qf.forum.proj.entity.Manager;
import com.qf.forum.proj.result.Result;
import com.qf.forum.proj.result.ResultData;
import com.qf.forum.proj.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/regist")
public class RegistController {

    @Autowired
    private ManagerService managerService;

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public Result managerRegist(@RequestBody Manager manager){
        boolean flag = managerService.registe(manager);
        if (flag)
            return new Result("200","注册成功");
        return new Result("000","该用户已存在");
    }


}
