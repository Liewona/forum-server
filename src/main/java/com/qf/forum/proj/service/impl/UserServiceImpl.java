package com.qf.forum.proj.service.impl;

import com.qf.forum.proj.dto.UserDto;
import com.qf.forum.proj.mapper.UserMapper;
import com.qf.forum.proj.result.ResultData;
import com.qf.forum.proj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultData getUserList(Integer page,Integer limit) {
        List<UserDto> users = userMapper.selectUser(page,limit);
        return new ResultData("200","",users);
    }
}
