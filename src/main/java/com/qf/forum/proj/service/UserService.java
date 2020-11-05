package com.qf.forum.proj.service;

import com.qf.forum.proj.dto.UserDto;
import com.qf.forum.proj.dto.EditDto;
import com.qf.forum.proj.result.ResultData;

public interface UserService {
    ResultData getUserList(Integer page,Integer limit);

    boolean registe(UserDto userDto);

    ResultData like(String uname, String phone, Integer page, Integer limit);

    void delete(String id);

    ResultData update(EditDto userEditDto);

    ResultData updateByTwo(UserDto userDto);

    ResultData selectUserDtoByUid(Integer id);
}
