package com.qf.forum.proj.service;

import com.qf.forum.proj.result.ResultData;
import org.apache.catalina.User;

public interface UserService {
    ResultData getUserList(Integer page,Integer limit);
}
