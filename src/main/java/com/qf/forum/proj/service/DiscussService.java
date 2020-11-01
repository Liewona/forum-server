package com.qf.forum.proj.service;
/*
 *   Author = Liewona
 *   Date = 2020/11/1 14:22
 */

import com.qf.forum.proj.dto.DiscussDto;

import java.util.List;

public interface DiscussService {

    List<DiscussDto> selectOnPage(int page, int limit);
}
