package com.qf.forum.proj.service.impl;
/*
 *   Author = Liewona
 *   Date = 2020/11/5 0:58
 */

import com.qf.forum.proj.entity.Reply;
import com.qf.forum.proj.mapper.ReplyMapper;
import com.qf.forum.proj.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyMapper replyMapper;

    @Override
    public List<Reply> selectByRid(int rid) {
        return replyMapper.selectByRid(rid);
    }
}
