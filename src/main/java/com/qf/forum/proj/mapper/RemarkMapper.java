package com.qf.forum.proj.mapper;
/*
 *   Author = Liewona
 *   Date = 2020/11/3 19:49
 */

import com.qf.forum.proj.entity.Remark;
import org.apache.ibatis.annotations.Insert;

public interface RemarkMapper {

    @Insert("INSERT INTO TB_REMARK(DID,CONTENT,CREATE_TIME,UID) VALUES(#{did},#{content},#{createTime},#{uid})")
    int addRemark(Remark remark);

}