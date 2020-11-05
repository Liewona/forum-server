package com.qf.forum.proj.mapper;

import com.qf.forum.proj.entity.Manager;
import org.apache.ibatis.annotations.Select;

public interface ManagerMapper {

    @Select("select id from TB_MANAGER where ACCOUNT = #{account}")
    Manager select(String account);

    @Select("insert into TB_MANAGER(ACCOUNT,NAME,PASSWORD,IMG) VALUES(#{account},#{name},#{password},#{img})")
    void insert(String account, String name, String password, String img);

    @Select("select ACCOUNT,PASSWORD ,NAME from TB_MANAGER where ACCOUNT = #{account}")
    Manager selectByLogin(String account);

}
