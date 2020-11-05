package com.qf.forum.proj.mapper;
/*
 *   Author = Liewona
 *   Date = 2020/11/3 19:49
 */

import com.qf.forum.proj.dto.RemarkDto;
import com.qf.forum.proj.entity.Remark;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RemarkMapper {

    @Insert("INSERT INTO TB_REMARK(DID,CONTENT,CREATE_TIME,UID) VALUES(#{did},#{content},#{createTime},#{uid})")
    int addRemark(Remark remark);

    @Select("SELECT R.ID,DID,CONTENT,CREATE_TIME,UID,UNAME,IMG FROM TB_REMARK R,TB_USER U WHERE DID=#{did} AND UID=U.ID")
    List<RemarkDto> selectByDid(int did);
}
