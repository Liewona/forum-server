package com.qf.forum.proj.service;
/*
 *   Author = Liewona
 *   Date = 2020/11/5 0:57
 */

import com.qf.forum.proj.entity.Reply;

import java.util.List;

public interface ReplyService {

    List<Reply> selectByRid(int rid);

    int addReply(Reply reply);
}
