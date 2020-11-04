package com.qf.forum.proj.controller;

import com.qf.forum.proj.entity.Manager;
import com.qf.forum.proj.result.Result;
import com.qf.forum.proj.result.ResultData;
import com.qf.forum.proj.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class LoginController {


    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/code" ,method = RequestMethod.GET)
    public void code(HttpServletRequest request, HttpServletResponse response,String uuid){
        //System.out.println(uuid);
        loginService.getCode(request,response,uuid);
    }

    @ResponseBody
    @RequestMapping(value = "/manger",method = RequestMethod.GET)
    public ResultData loginByManager(HttpServletRequest request, String account,String password,String uuid,String code){
        return loginService.loginByManager(request,account,password,code,uuid);

    }

    @ResponseBody
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public ResultData loginByUser(HttpServletRequest request,String account,String password, String code,String uuid){
        //System.out.println(uuid);
        return loginService.loginByUser(request,account,password,code,uuid);
    }

}
