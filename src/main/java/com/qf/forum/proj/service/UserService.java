package com.qf.forum.proj.service;

import com.qf.forum.proj.dto.UserDto;
import com.qf.forum.proj.dto.EditDto;
import com.qf.forum.proj.entity.Account;
import com.qf.forum.proj.entity.UserAccount;
import com.qf.forum.proj.result.ResultData;
import org.springframework.stereotype.Service;


public interface UserService {
    ResultData getUserList(Integer page,Integer limit);

    boolean registe(UserDto userDto);

    ResultData like(String uname, String phone, Integer page, Integer limit);

    void delete(String id);

    ResultData update(EditDto userEditDto);

    ResultData updateByTwo(UserDto userDto);

<<<<<<< HEAD
    ResultData selectUserDtoById(Integer id);

    ResultData updateByPrimaryKeySelective(UserDto record);

    ResultData updateAccount(Account account);

    ResultData updateByPrimaryKey(UserDto record);
=======
    ResultData selectUserDtoByUid(Integer id);
>>>>>>> 782d0409b758da0e067f5a2bffcda29a435a327c
}
