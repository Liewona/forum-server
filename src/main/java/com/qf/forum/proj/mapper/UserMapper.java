package com.qf.forum.proj.mapper;

import com.qf.forum.proj.dto.UserDto;
import com.qf.forum.proj.entity.UserAccount;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select ID,USERNAME,PASSWORD from TB_ACCOUNT where ACCOUNT = #{account}")
    UserAccount selectByLogin(String account);

    @Select("select UNAME,PHONE,REGISTER_TIME as REGISTERTIME,AGE,SEX,IMG from TB_USER,TB_ACCOUNT where TB_USER.ID = TB_ACCOUNT.UID limit #{page} #{limt}")
    List<UserDto> selectUser(Integer page, Integer limit);
}
