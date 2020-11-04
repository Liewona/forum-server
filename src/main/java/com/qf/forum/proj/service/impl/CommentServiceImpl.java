package com.qf.forum.proj.service.impl;

import com.qf.forum.proj.dto.CommentDto;
import com.qf.forum.proj.dto.EditDto;
import com.qf.forum.proj.mapper.CommentMapper;
import com.qf.forum.proj.result.ResultData;
import com.qf.forum.proj.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public ResultData getCommentList(Integer page, Integer limit) {
        Integer pages = (page - 1)*limit;
        List<CommentDto> remarks = commentMapper.selectComment(pages,limit);
        Long count = commentMapper.getCommentCount();
        return new ResultData("0","",count,remarks);
    }

    @Override
    public ResultData like(String content, Integer page, Integer limit) {
        Integer pages = (page - 1)*limit;
        List<CommentDto> commentDtos = commentMapper.like(content, pages,limit);
        Long count = commentMapper.getLikeCount(content);
        return new ResultData("0","",count,commentDtos);
    }

    @Override
    public ResultData update(EditDto editDto) {
        commentMapper.update(editDto.getId(),editDto.getField(),editDto.getVal());
        return new ResultData("200","修改成功",null);
    }

    @Override
    public ResultData searchByTime(String time,Integer page,Integer limit) {
        System.out.println(time);
        List<CommentDto> commentDtos = null;
        Integer pages = (page - 1)*limit;
        Long count = 0L;
        if (!time.equals("")){
            String times[] = time.split("~");
            System.out.println(times[0] +"\t" +times[1]);
            commentDtos = commentMapper.searchByTime(times[0],times[1],pages,limit);
            count = commentMapper.searchByTimeCount(times[0],times[1]);
        }else{
            commentDtos = commentMapper.selectComment(pages,limit);
            count = commentMapper.getCommentCount();
        }

        return new ResultData("0","",count,commentDtos);
    }

//    @Override
//    public void delete(String id) {
//        commentMapper.delete()
//    }
}
