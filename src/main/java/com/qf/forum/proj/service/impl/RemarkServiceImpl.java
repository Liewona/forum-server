package com.qf.forum.proj.service.impl;
/*
 *   Author = Liewona
 *   Date = 2020/11/3 19:48
 */

import com.qf.forum.config.exception.MessageException;
import com.qf.forum.proj.entity.Remark;
import com.qf.forum.proj.mapper.RemarkMapper;
import com.qf.forum.proj.result.Result;
import com.qf.forum.proj.service.RemarkService;
import com.qf.forum.utils.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemarkServiceImpl implements RemarkService {

    @Autowired
    private RemarkMapper remarkMapper;

    @Override
    public void addRemark(Result rst, Remark remark) {

        try {
            int insert = remarkMapper.addRemark(remark);
            if(insert < 1) {
                throw new MessageException("插入失败");
            }
        } catch (MessageException me) {
            rst.reset("9901", me.getMessage());
        } catch (Exception e) {
            rst.reset(ResultEnum.ERROR);
        }
        rst.reset(ResultEnum.SUCCESS);
    }

    @Override
    public List<Remark> selectByUid(int uid) {
        return remarkMapper.selectByUid(uid);
    }
}
