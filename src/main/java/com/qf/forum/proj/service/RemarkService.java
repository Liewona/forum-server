package com.qf.forum.proj.service;
/*
 *   Author = Liewona
 *   Date = 2020/11/3 19:48
 */

import com.qf.forum.proj.entity.Remark;
import com.qf.forum.proj.result.Result;

public interface RemarkService {

    void addRemark(Result rst, Remark remark);

}
