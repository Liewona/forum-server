package com.qf.forum.proj.service;

import com.qf.forum.proj.result.ResultData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoginService {
    void getCode(HttpServletRequest request, HttpServletResponse response);

    ResultData loginByManager(HttpServletRequest request, String account, String password, String code);

    ResultData loginByUser(HttpServletRequest request, String account, String password, String code);
}
