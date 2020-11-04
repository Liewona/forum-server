package com.qf.forum.proj.service.impl;

import cn.dsna.util.images.ValidateCode;
import com.qf.forum.proj.entity.Manager;
import com.qf.forum.proj.entity.UserAccount;
import com.qf.forum.proj.mapper.ManagerMapper;
import com.qf.forum.proj.mapper.UserMapper;
import com.qf.forum.proj.result.ResultData;
import com.qf.forum.proj.service.LoginService;
import com.qf.forum.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    ManagerMapper managerMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public void getCode(HttpServletRequest request, HttpServletResponse response) {
        ValidateCode validateCode = new ValidateCode(160,40,4,30);
        String code = validateCode.getCode();
        System.out.println(code);
        request.getSession().setAttribute("code",code);
        System.out.println(request.getSession().getId());
        try {
            validateCode.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ResultData loginByManager(HttpServletRequest request, String account, String password, String code) {
        //System.out.println(code+"\t"+request.getSession().getAttribute("code"));
        if (code.trim().equalsIgnoreCase((String) request.getSession().getAttribute("code"))){
            Manager manager = managerMapper.selectByLogin(account);
            if(manager != null && manager.getPassword().equals(Md5Util.getMd5(account,password)) )
                return new ResultData("200","登录成功",null);
            else
                return new ResultData("000","账号或者密码错误",null);

        }else{
            return new ResultData("000","验证码错误",null);
        }
    }

    @Override
    public ResultData loginByUser(HttpServletRequest request, String account, String password, String code) {
        if (code.trim().equalsIgnoreCase((String) request.getSession().getAttribute("code"))){
            UserAccount user = userMapper.selectByLogin(account);
            if(user != null && user.getPassword().equals(Md5Util.getMd5(account,password)) )
                return new ResultData("200","登录成功",null);
            else
                return new ResultData("000","账号或者密码错误",null);

        }else{
            return new ResultData("000","验证码错误",null);
        }
    }
}
