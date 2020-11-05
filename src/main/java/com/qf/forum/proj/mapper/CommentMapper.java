package com.qf.forum.proj.mapper;

import com.qf.forum.proj.dto.CommentDto;
import com.qf.forum.proj.entity.Remark;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface CommentMapper {

    @Select("select TB_REMARK.ID,UNAME,CONTENT,CREATE_TIME as CREATETIME, UID from TB_REMARK , TB_USER where TB_USER.ID = TB_REMARK.UID limit #{page},#{limit}")
    List<CommentDto> selectComment(Integer page, Integer limit);

    @Select("select count(TB_REMARK.ID) from TB_REMARK , TB_USER where TB_USER.ID = TB_REMARK.UID")
    Long getCommentCount();

    List<CommentDto> like(@Param("content") String content, @Param("page") Integer pages, @Param("limit") Integer limit);

    Long getLikeCount(@Param("content") String content);

    void update(@Param("id") String id, @Param("field") String field, @Param("val") String val);

    List<CommentDto> searchByTime(@Param("time1") String time1,@Param("time2") String time2,@Param("page") Integer page,@Param("limit") Integer limit);

    Long searchByTimeCount(@Param("time1") String time1, @Param("time2") String time2);

    @Select("delete from TB_REMARK where ID = #{id}")
    void delete(String id);

    @Select("delete from TB_REPLY where REMARK_ID = #{id}")
    void deleteReply(String id);
}
