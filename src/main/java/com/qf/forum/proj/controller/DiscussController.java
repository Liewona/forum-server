package com.qf.forum.proj.controller;
/*
 *   Author = Liewona
 *   Date = 2020/11/1 14:57
 */

import com.qf.forum.proj.dto.DiscussDto;
import com.qf.forum.proj.result.Result;
import com.qf.forum.proj.result.ResultData;
import com.qf.forum.proj.service.DiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("discuss")
@RestController
public class DiscussController {

    @Autowired
    private DiscussService discussService;

    @GetMapping
    public Result selectOnPage(Integer page, Integer limit) {
        if(page == null || page <= 0) {
            page = 1;
        }
        if(limit == null || limit <= 0) {
            limit = 10;
        }
        List<DiscussDto> discussDtoList = discussService.selectOnPage(page, limit);
        return new ResultData("0000", "success", discussDtoList);
    }

}
