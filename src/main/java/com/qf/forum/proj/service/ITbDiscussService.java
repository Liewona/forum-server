package com.qf.forum.proj.service;

import com.qf.forum.proj.dto.TbDiscussDto;
import com.qf.forum.proj.dto.UpdateTbDiscussDto;
import com.qf.forum.proj.entity.TbDiscuss;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qf.forum.proj.result.Result;
import com.qf.forum.proj.result.ResultData;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author FPF
 * @since 2020-11-03
 */
public interface ITbDiscussService extends IService<TbDiscuss> {

     List<TbDiscussDto> selectOnPage(Integer page, Integer limit);
     Result updateByElement(UpdateTbDiscussDto updateTbDiscussDto);
     Result deleteById(String[] ids);
     ResultData getCount(ArrayList<String> list);

     List<TbDiscuss> selectFive();
}
