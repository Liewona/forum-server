package com.qf.forum.proj.service;

import com.qf.forum.proj.dto.EditDto;
import com.qf.forum.proj.result.ResultData;

public interface CommentService {
    ResultData getCommentList(Integer page, Integer limit);

    ResultData like(String content, Integer page, Integer limit);

    ResultData update(EditDto editDto);

    ResultData searchByTime(String time,Integer page,Integer limit);

//    void delete(String id);
}
