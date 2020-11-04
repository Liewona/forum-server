package com.qf.forum.proj.service;

import com.qf.forum.proj.dto.UserDto;
import com.qf.forum.proj.dto.UserEditDto;
import com.qf.forum.proj.entity.UserAccount;
import com.qf.forum.proj.result.ResultData;
import org.apache.catalina.User;

public interface UserService {
    ResultData getUserList(Integer page,Integer limit);

    boolean registe(UserDto userDto);

    ResultData like(String uname, String phone, Integer page, Integer limit);

    void delete(String id);

    ResultData update(UserEditDto userEditDto);

    ResultData updateByTwo(UserDto userDto);
}
