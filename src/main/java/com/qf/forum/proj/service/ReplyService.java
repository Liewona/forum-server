package com.qf.forum.proj.service;
/*
 *   Author = Liewona
 *   Date = 2020/11/5 0:57
 */

import com.qf.forum.proj.dto.EditDto;
import com.qf.forum.proj.dto.ReplyDto;
import com.qf.forum.proj.entity.Reply;
import com.qf.forum.proj.result.Result;
import com.qf.forum.proj.result.ResultData;

import java.util.List;

public interface ReplyService {

    List<ReplyDto> selectByRid(int rid);

    int addReply(Reply reply);

    ResultData getReplyList(Integer id, Integer page, Integer limit);

    ResultData like(Integer id,String content, Integer page, Integer limit);

    ResultData update(EditDto editDto);

    ResultData searchByTime(Integer id, String time, Integer page, Integer limit);

    Result delete(Integer[] id);

    List<ReplyDto> getReplyDtoList(int rid);

}
