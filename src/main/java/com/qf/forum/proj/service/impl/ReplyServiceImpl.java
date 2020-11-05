package com.qf.forum.proj.service.impl;
/*
 *   Author = Liewona
 *   Date = 2020/11/5 0:58
 */

import com.qf.forum.proj.dto.EditDto;
import com.qf.forum.proj.dto.ReplyDto;
import com.qf.forum.proj.entity.Reply;
import com.qf.forum.proj.mapper.ReplyMapper;
import com.qf.forum.proj.mapper.UserMapper;
import com.qf.forum.proj.result.Result;
import com.qf.forum.proj.result.ResultData;
import com.qf.forum.proj.service.ReplyService;
import com.qf.forum.utils.CommUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyMapper replyMapper;


    @Autowired
    private UserMapper userMapper;

    @Override
    public List<ReplyDto> selectByRid(int rid) {
        return replyMapper.selectByRid(rid);
    }

    @Override
    public int addReply(Reply reply) {
        reply.setCreateTime(CommUtil.getNowDateTime());
        return replyMapper.addReply(reply);
    }

    @Override
    public ResultData getReplyList(Integer id, Integer page, Integer limit) {
        Integer pages = (page - 1)*limit;
        List<Reply> replies = replyMapper.selectByRemarkId(id,pages,limit);
        Long count = replyMapper.getSelectByRemarkIdCount(id);
        return new ResultData("0", "",count,replies);
    }

    @Override
    public ResultData like(Integer id,String content, Integer page, Integer limit) {
        Integer pages = (page - 1)*limit;
        List<Reply> replies = replyMapper.likeContent(id,content,pages,limit);
        Long count = replyMapper.likeContentCount(id,content);
        return new ResultData("0","",count,replies);
    }

    @Override
    public ResultData update(EditDto editDto) {
        Integer res = replyMapper.update(editDto);
        if (res <= 0)
            return new ResultData("000","修改失败",null);
        return new ResultData("200","修改成功",null);
    }

    @Override
    public ResultData searchByTime(Integer id, String time, Integer page, Integer limit) {
        List<Reply> replies = null;
        Integer pages = (page - 1)*limit;
        Long count = 0L;
        if (!time.equals("")){
            String times[] = time.split("~");
            System.out.println(times[0] +"\t" +times[1]);
            replies = replyMapper.searchByTime(id,times[0],times[1],pages,limit);
            count = replyMapper.searchByTimeCount(id,times[0],times[1]);
        }else{
            replies = replyMapper.selectByRemarkId(id,pages,limit);
            count = replyMapper.getSelectByRemarkIdCount(id);
        }

        return new ResultData("0","",count,replies);
    }

    @Transactional
    @Override
    public Result delete(Integer[] ids) {
        String msg = "删除成功";
        for (Integer id:ids){
            replyMapper.delete(id);
        }
        return new ResultData("200",msg,null);
    }

    @Override
    public List<ReplyDto> getReplyDtoList(int rid) {
        List<ReplyDto> replyList = selectByRid(rid);
        for(ReplyDto reply : replyList) {
            getAndSetUserName(reply);
        }
        return replyList;
    }

    private void getAndSetUserName(ReplyDto replyDto) {
        String fromName = userMapper.selectNameById(replyDto.getFromId());
        replyDto.setFromName(fromName);
        String toName = userMapper.selectNameById(replyDto.getToId());
        replyDto.setToName(toName);
    }

    private void getAndSetFromImg(ReplyDto replyDto) {
        String path = userMapper.selectImgById(replyDto.getFromId());
        replyDto.setFromImg(path);
    }
}
