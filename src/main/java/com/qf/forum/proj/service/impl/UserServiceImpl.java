package com.qf.forum.proj.service.impl;

import com.qf.forum.proj.dto.UserDto;
import com.qf.forum.proj.dto.EditDto;
import com.qf.forum.proj.entity.Account;
import com.qf.forum.proj.entity.User;
import com.qf.forum.proj.entity.UserAccount;
import com.qf.forum.proj.mapper.UserMapper;
import com.qf.forum.proj.result.ResultData;
import com.qf.forum.proj.service.UserService;
import com.qf.forum.utils.CommUtil;
import com.qf.forum.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public boolean registe(UserDto userDto) {
        UserAccount user1 = userMapper.select(userDto.getUsername());
        if (user1 != null)
            return false;
        String password = Md5Util.getMd5(userDto.getUsername(),userDto.getPassword());
        userMapper.insertUser(userDto.getUname(), CommUtil.getNowDateTime(),userDto.getSex());
        UserDto userDto1 = userMapper.selectUserDtoByUname(userDto.getUname());
        userMapper.insertAccount(userDto.getUsername(),password,userDto1.getId());
        return true;
    }

    @Override
    public ResultData like(String uname, String phone,Integer page,Integer limit) {
        Integer pages = (page - 1)*limit;
        List<UserDto> userDtos =  userMapper.like(uname,phone,pages,limit);
        Long count = userMapper.likeCount(uname,phone);
        return new ResultData("0","",count,userDtos);
    }

    @Transactional
    @Override
    public void delete(String id) {
        userMapper.deleteUser(id);
        userMapper.deleteAccount(id);
    }

    @Override
    public ResultData update(EditDto userEditDto) {
        userMapper.update(userEditDto.getId(),userEditDto.getField(),userEditDto.getVal());
        return new ResultData("200","修改完成",null);
    }

    @Override
    public ResultData updateByTwo(UserDto userDto) {
        userMapper.updateTwo(userDto.getSex(),userDto.getImg(),userDto.getId());
        return new ResultData("0","修改成功",null);
    }

    @Override

    public ResultData selectUserDtoById(Integer id) {
        UserDto userDto =userMapper.selectUserDtoById(id);
        userDto.setPassword("");
        return new ResultData("0","查询成功",userDto);
    }

    @Override
    public ResultData updateByPrimaryKeySelective(UserDto record) {


        userMapper.updateByPrimaryKeySelective(record);
        UserDto userDto = userMapper.selectUserDtoById(record.getId());
        return new ResultData("0","修改成功",userDto);
    }

    @Override
    public ResultData updateAccount(Account account) {

        userMapper.updateAccount(account.getPassword(),account.getUid());
        ResultData resultData = new ResultData();
        resultData.setCode("0");
        return resultData;
    }

    @Override
    public ResultData updateByPrimaryKey(UserDto record) {
       return null;
    }



    @Override
    public ResultData getUserList(Integer page,Integer limit) {
        Integer pages = (page - 1)*limit;
        List<UserDto> users = userMapper.selectUser(pages,limit);
        Long count = userMapper.getUserListCount();
        return new ResultData("0","",count,users);
    }


}
