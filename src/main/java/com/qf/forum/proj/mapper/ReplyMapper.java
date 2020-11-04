package com.qf.forum.proj.mapper;
/*
 *   Author = Liewona
 *   Date = 2020/11/5 1:00
 */

import com.qf.forum.proj.entity.Reply;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ReplyMapper {

    @Select("SELECT ID,FORM,TO,CONTENT,CREATE_TIME,REMARK_ID FROM TB_REPLY WHERE REMARK_ID=#{rid}")
    List<Reply> selectByRid(int rid);

    int addReply(Reply reply);
}
