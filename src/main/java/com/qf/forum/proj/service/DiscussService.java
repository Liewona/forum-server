package com.qf.forum.proj.service;
/*
 *   Author = Liewona
 *   Date = 2020/11/1 14:22
 */

import com.qf.forum.proj.dto.DiscussDto;
import com.qf.forum.proj.entity.Discuss;
import com.qf.forum.proj.result.Result;
import com.qf.forum.proj.result.ResultData;
import com.qf.forum.utils.DiscussQuery;

import java.util.List;

public interface DiscussService {

    List<DiscussDto> selectOnPage(int page, int limit);

    void addDiscuss(Result rst, Discuss discuss);

    List<DiscussDto> selectDiscuss(DiscussQuery query);

    int selectCount();

    DiscussDto selectById(int id);

    public ResultData selectDiscussByUserId(Integer uid ,Integer start , Integer limit);

    /// @Select("SELECT COUNT(D.ID) FROM TB_DISCUSS D,TB_USER U  WHERE  D.UID=#{uid} D.UID=U.ID")
    ResultData selectCountByUserId();
}
