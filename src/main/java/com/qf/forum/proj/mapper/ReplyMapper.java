package com.qf.forum.proj.mapper;
/*
 *   Author = Liewona
 *   Date = 2020/11/5 1:00
 */

import com.qf.forum.proj.dto.EditDto;
import com.qf.forum.proj.entity.Reply;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface ReplyMapper {

    @Select("SELECT ID,FORM,TO,CONTENT,CREATE_TIME,REMARK_ID FROM TB_REPLY WHERE REMARK_ID=#{rid}")
    List<Reply> selectByRid(int rid);

    int addReply(Reply reply);

    @Select("select ID,FROM_ID as fromId,TO_ID as toId,CONTENT,CREATE_TIME as createTime,REMARK_ID as remarkId from TB_REPLY where REMARK_ID = #{id} limit #{page} ,#{limit}")
    List<Reply> selectByRemarkId(Integer id, Integer page, Integer limit);

    @Select("select count(ID) from TB_REPLY where REMARK_ID  = #{id} ")
    Long getSelectByRemarkIdCount(Integer id);


    List<Reply> likeContent(@Param("id") Integer id, @Param("content") String content, @Param("page") Integer pages, @Param("limit") Integer limit);

    Long likeContentCount(@Param("id") Integer id,@Param("content") String content);


    Integer update(EditDto editDto);


    List<Reply> searchByTime(@Param("id") Integer id, @Param("time") String time,@Param("time1") String time1, @Param("page") Integer page,@Param("limit") Integer limit);

    Long searchByTimeCount(@Param("id") Integer id, @Param("time") String time, @Param("time1") String time1);

    @Select("delete from TB_REPLY where ID = #{id}")
    Integer delete(Integer id);
}
