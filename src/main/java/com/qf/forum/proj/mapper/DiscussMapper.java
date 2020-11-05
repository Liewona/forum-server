package com.qf.forum.proj.mapper;
/*
 *   Author = Liewona
 *   Date = 2020/11/1 14:21
 */

import com.qf.forum.proj.dto.DiscussDto;
import com.qf.forum.proj.entity.Discuss;
import com.qf.forum.utils.DiscussQuery;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DiscussMapper {
    @Select("SELECT D.ID,TITLE,CONTENT,CREATE_TIME,UID,CLICK_COUNT,UNAME FROM TB_DISCUSS D,TB_USER U WHERE D.UID=U.ID LIMIT #{start},#{limit}")
    List<DiscussDto> selectOnPage(int start, int limit);

    @Insert("INSERT INTO TB_DISCUSS(TITLE,CONTENT,CREATE_TIME,UID,CLICK_COUNT) VALUES(#{title},#{content},#{createTime},#{uid},#{clickCount})")
    int addDiscuss(Discuss discuss);

    @Select("SELECT D.ID,TITLE,CONTENT,CREATE_TIME,UID,CLICK_COUNT,UNAME FROM TB_DISCUSS D,TB_USER U WHERE D.UID=U.ID ORDER BY CLICK_COUNT LIMIT #{start},#{limit}")
    List<DiscussDto> selectOnPageByHot(int start, int limit);

    @Select("SELECT COUNT(ID) FROM TB_DISCUSS")
    int selectCount();

    List<DiscussDto> selectDiscuss(DiscussQuery query);

    @Select("SELECT D.ID,TITLE,CONTENT,CREATE_TIME,UID,CLICK_COUNT,UNAME,IMG FROM TB_DISCUSS D,TB_USER U WHERE D.ID=#{id}  AND D.UID=U.ID")
    DiscussDto selectById(int id);

    @Update("UPDATE TB_DISCUSS SET CLICK_COUNT=CLICK_COUNT+1 WHERE ID=#{id} ")
    void addClick(int id);
}
