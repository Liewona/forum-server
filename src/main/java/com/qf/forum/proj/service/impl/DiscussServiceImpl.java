package com.qf.forum.proj.service.impl;
/*
 *   Author = Liewona
 *   Date = 2020/11/1 14:22
 */

import com.qf.forum.proj.dto.DiscussDto;
import com.qf.forum.proj.mapper.DiscussMapper;
import com.qf.forum.proj.service.DiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussServiceImpl implements DiscussService {

    @Autowired
    private DiscussMapper discussMapper;

    @Override
    public List<DiscussDto> selectOnPage(int page, int limit) {
        List<DiscussDto> discussDtoList = discussMapper.selectOnPage(limit * (page - 1), limit);
        return discussDtoList;
    }
}
