package com.qf.forum.proj.mapper;

import com.qf.forum.proj.dto.DiscussDto;
import com.qf.forum.proj.dto.TbDiscussCountDto;
import com.qf.forum.proj.dto.TbDiscussDto;
import com.qf.forum.proj.entity.TbDiscuss;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author FPF
 * @since 2020-11-03
 */
@Mapper
public interface TbDiscussMapper extends BaseMapper<TbDiscuss> {

    @Select("SELECT D.ID,TITLE,CONTENT,CREATE_TIME,UID,CLICK_COUNT,UNAME FROM TB_DISCUSS D,TB_USER U WHERE D.UID=U.ID LIMIT #{start},#{limit}")
    List<DiscussDto> selectOnPage(@Param("start") int start, @Param("limit") int limit);

    @Select("SELECT D.ID,TITLE,CONTENT,CREATE_TIME,UID,CLICK_COUNT,UNAME FROM TB_DISCUSS D,TB_USER U WHERE D.UID=U.ID and D.ID=#{id}")
    List<TbDiscussDto> selectById(String id);

    @Update("update TB_DISCUSS set TITLE=#{val} where ID=#{id}" )
    void updateByTitle(@Param("id") String id,@Param("val") String val);

    @Update("update TB_DISCUSS set CONTENT=#{val} where ID=#{id}" )
    void updateByContent(@Param("id") String id,@Param("val") String val);

    @Delete("delete from TB_DISCUSS where ID=#{id}")
    void deleteById(@Param("id") String id);

    @Select("select count(*) from TB_DISCUSS where CREATE_TIME like  concat(#{time},'%') ")
    @Results({
            @Result(column = "count(*)",property = "count")
    })
    public List<TbDiscussCountDto> getCount(@Param("time") String time);

    @Select("select * from (select * from TB_DISCUSS order by CLICK_COUNT desc ) as tmp limit 5 ")
    List<TbDiscuss> selectFont();
}
