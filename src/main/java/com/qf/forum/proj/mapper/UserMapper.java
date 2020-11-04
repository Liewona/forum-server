package com.qf.forum.proj.mapper;

import com.qf.forum.proj.dto.UserDto;
import com.qf.forum.proj.entity.UserAccount;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface UserMapper {

    @Select("select ID,USERNAME,PASSWORD from TB_ACCOUNT where USERNAME = #{account}")
    UserAccount selectByLogin(String account);

    @Select("select TB_USER.ID,USERNAME,UNAME,PHONE,REGISTER_TIME as REGISTERTIME,AGE,SEX,IMG from TB_USER,TB_ACCOUNT where TB_USER.ID = TB_ACCOUNT.UID limit #{page}, #{limit}")
    List<UserDto> selectUser(Integer page, Integer limit);

    @Select("select id from TB_ACCOUNT where USERNAME = #{username}")
    UserAccount select(String username);

    @Select("select id from TB_USER where UNAME = #{uname}")
    UserDto selectUserDtoByUname(String uname);

    @Select("insert into TB_USER(UNAME,REGISTER_TIME,SEX) VALUES(#{uname},#{nowDateTime},#{sex}) ")
    void insertUser(String uname, String nowDateTime,String sex);

    @Select("insert into TB_ACCOUNT(USERNAME,PASSWORD,UID) VALUES(#{username},#{password},#{id})")
    void insertAccount(String username, String password, Integer id);

    @Select("select count(TB_USER.ID) from TB_USER,TB_ACCOUNT where TB_USER.ID = TB_ACCOUNT.UID ")
    Long getUserListCount();

    List<UserDto> like(@Param("uname") String uname, @Param("phone") String phone, @Param("page") Integer pages, @Param("limit") Integer limit);

    Long likeCount(@Param("uname") String uname, @Param("phone") String phone);

    @Select("delete from TB_USER where ID = #{id}")
    void deleteUser(String id);

    @Select("delete from TB_ACCOUNT where UID = #{id}")
    void deleteAccount(String id);

    void update(@Param("id") String id,@Param("field") String field,@Param("val") String val);

    @Select("update TB_USER set SEX = #{sex} ,IMG = #{img} where ID = #{id} ")
    void updateTwo(String sex, String img, Integer id);
}
