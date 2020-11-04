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

    @Override
    public boolean registe(Manager manager) {
        Manager manager1 = managerMapper.select(manager.getAccount());
        if (manager1 != null)
            return false;
        String password = Md5Util.getMd5(manager.getAccount(),manager.getPassword());
        managerMapper.insert(manager.getAccount(),manager.getName(),password,manager.getImg());
        return true;
    }
}
