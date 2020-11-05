package com.qf.forum.proj.service;
/*
 *   Author = Liewona
 *   Date = 2020/11/3 19:48
 */

import com.qf.forum.proj.dto.RemarkDto;
import com.qf.forum.proj.entity.Remark;
import com.qf.forum.proj.result.Result;

import java.util.List;

public interface RemarkService {

    void addRemark(Result rst, Remark remark);


    List<RemarkDto> selectByDid(int did);
}
