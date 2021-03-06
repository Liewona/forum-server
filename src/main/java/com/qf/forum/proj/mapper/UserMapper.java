package com.qf.forum.proj.mapper;

import com.qf.forum.proj.dto.UserDto;
import com.qf.forum.proj.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.security.core.parameters.P;

import java.util.List;
@Mapper
public interface UserMapper {

    @Select("select A.ID,USERNAME,PASSWORD,UID,UNAME,AGE,SEX,PHONE,REGISTER_TIME from TB_ACCOUNT A, TB_USER U where USERNAME = #{account} AND A.UID=U.ID")
    Account selectByLogin(String account);

    @Select("select TB_USER.ID,USERNAME,UNAME,PHONE,REGISTER_TIME as REGISTERTIME,AGE,SEX,IMG from TB_USER,TB_ACCOUNT where TB_USER.ID = TB_ACCOUNT.UID limit #{page}, #{limit}")
    List<UserDto> selectUser(Integer page, Integer limit);

    @Select("select id from TB_ACCOUNT where USERNAME = #{username}")
    Account select(String username);

    @Select("select id from TB_USER where UNAME = #{uname}")
    UserDto selectUserDtoByUname(String uname);

    @Select("select * from TB_USER where ID = #{id}")
    UserDto selectUserDtoById(Integer id);

    @Select("insert into TB_USER(UNAME,REGISTER_TIME,SEX) VALUES(#{uname},#{nowDateTime},#{sex}) ")
    void insertUser(String uname, String nowDateTime,String sex);

    @Select("insert into TB_ACCOUNT(USERNAME,PASSWORD,UID) VALUES(#{username},#{password},#{id})")
    void insertAccount(String username, String password, Integer id);

    @Select("update TB_ACCOUNT set PASSWORD = #{password} where UID =#{id} ")
    void updateAccount( String password, Integer id);

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

    int updateByPrimaryKeySelective(UserDto record);

    int updateByPrimaryKey(UserDto record);

    @Select("SELECT UNAME FROM TB_USER WHERE ID=#{id}")
    String selectNameById(int id);

    @Select("SELECT IMG FROM TB_USER WHERE ID=#{id}")
    String selectImgById(int id);
}
