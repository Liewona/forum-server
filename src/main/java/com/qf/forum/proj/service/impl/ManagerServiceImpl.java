package com.qf.forum.proj.service.impl;

import com.qf.forum.proj.entity.Manager;
import com.qf.forum.proj.mapper.ManagerMapper;
import com.qf.forum.proj.service.ManagerService;
import com.qf.forum.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    ManagerMapper managerMapper;


}
