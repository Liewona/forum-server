package com.qf.forum.proj.mapper;
/*
 *   Author = Liewona
 *   Date = 2020/11/1 14:21
 */

import com.qf.forum.proj.dto.DiscussDto;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DiscussMapper {
    @Select("SELECT D.ID,TITLE,CONTENT,CREATE_TIME,UID,CLICK_COUNT,UNAME FROM TB_DISCUSS D,TB_USER U WHERE D.UID=U.ID LIMIT #{start},#{limit}")
    List<DiscussDto> selectOnPage(int start, int limit);
}