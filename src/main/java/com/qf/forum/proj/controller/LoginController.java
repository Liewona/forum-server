package com.qf.forum.proj.controller;

import com.alibaba.fastjson.JSONObject;
import com.qf.forum.config.aspect.annotation.LoginCheck;
import com.qf.forum.proj.entity.Account;
import com.qf.forum.proj.entity.Manager;
import com.qf.forum.proj.result.Result;
import com.qf.forum.proj.result.ResultData;
import com.qf.forum.proj.service.LoginService;
import com.qf.forum.utils.ResultEnum;
import com.qf.forum.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class LoginController {


    @Autowired
    private LoginService loginService;

    @ResponseBody
    @PostMapping("/logmsg")
    public Result getLoginMessage(HttpServletRequest request) {
        Account user = (Account) request.getSession().getAttribute(StringUtils.SESSION_KEY);
        if(user == null) {
            return new Result(ResultEnum.ERROR);
        }
        user.setPassword(null);
        user.setRegisterTime(null);
        return new ResultData(ResultEnum.SUCCESS, user);
    }

    @ResponseBody
    @PostMapping("logout")
    public Result logout(HttpServletRequest request) {
        request.getSession().setAttribute(StringUtils.SESSION_KEY, null);
        return new Result(ResultEnum.SUCCESS);
    }

    @RequestMapping(value = "/code" ,method = RequestMethod.GET)
    public void code(HttpServletRequest request, HttpServletResponse response,String uuid){
        //System.out.println(uuid);
        loginService.getCode(request,response,uuid);
    }

    @ResponseBody
    @RequestMapping(value = "/loginManager",method = RequestMethod.GET)
    public ResultData loginByManager(HttpServletRequest request, String account,String password,String uuid,String code){
        return loginService.loginByManager(request,account,password,code,uuid);

    }

    @ResponseBody
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public ResultData loginByUser(HttpServletRequest request,String account,String password, String code,String uuid){
        //System.out.println(uuid);
        return loginService.loginByUser(request,account,password,code,uuid);
    }

    @ResponseBody
    //@LoginCheck
    @RequestMapping(value = "/manager",method = RequestMethod.GET)
    public Result getManager(HttpServletRequest request,String account){
        System.out.println(account);
        return loginService.getManager(account);
    }

}
