package com.qf.forum.proj.service.impl;

import cn.dsna.util.images.ValidateCode;
import com.qf.forum.proj.entity.Manager;
import com.qf.forum.proj.entity.UserAccount;
import com.qf.forum.proj.mapper.ManagerMapper;
import com.qf.forum.proj.mapper.UserMapper;
import com.qf.forum.proj.result.Result;
import com.qf.forum.proj.result.ResultData;
import com.qf.forum.proj.service.LoginService;
import com.qf.forum.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Duration;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    ManagerMapper managerMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @Override
    public void getCode(HttpServletRequest request, HttpServletResponse response,String uuid) {
        ValidateCode validateCode = new ValidateCode(160,40,4,30);
        String code = validateCode.getCode();
        redisTemplate.opsForValue().set(uuid, code, Duration.ofSeconds(120));
        try {
            validateCode.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ResultData loginByManager(HttpServletRequest request, String account, String password, String code,String uuid) {

        String code1 = (String) redisTemplate.opsForValue().get(uuid);
        System.out.println(code1);
        if (code1 ==null){
            return new ResultData("000","验证码已失效，重新刷新后再试",null);
        }
        if (code.trim().equalsIgnoreCase(code1)){
            Manager manager = managerMapper.selectByLogin(account);
            if(manager != null && manager.getPassword().equals(Md5Util.getMd5(account,password)) ){
                request.getSession().setAttribute("user",manager);
                return new ResultData("200","登录成功",null);
            }
            else
                return new ResultData("000","账号或者密码错误",null);

        }else{
            return new ResultData("000","验证码错误",null);
        }
    }

    @Override
    public ResultData loginByUser(HttpServletRequest request, String account, String password, String code,String uuid) {
        String code1 = (String) redisTemplate.opsForValue().get(uuid);
        System.out.println(code1);
        if (code1 ==null){
            return new ResultData("000","验证码已失效，重新刷新后再试",null);
        }
        if (code.trim().equalsIgnoreCase(code1)){
            UserAccount user = userMapper.selectByLogin(account);
            if(user != null && user.getPassword().equals(Md5Util.getMd5(account,password)) ){
                request.getSession().setAttribute("user",user);
                System.out.println(user.toString());
                return new ResultData("200","登录成功",user);
            }

            else
                return new ResultData("000","账号或者密码错误",null);

        }else{
            return new ResultData("000","验证码错误",null);
        }
    }

    @Override
    public Result getManager(String account) {
        Manager manager = managerMapper.selectByLogin(account);
        return new ResultData("200","",manager);
    }
}
