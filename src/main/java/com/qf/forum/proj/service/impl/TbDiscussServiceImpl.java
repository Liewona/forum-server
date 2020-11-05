package com.qf.forum.proj.service.impl;

import com.qf.forum.proj.dto.TbDiscussCountDto;
import com.qf.forum.proj.dto.TbDiscussDto;
import com.qf.forum.proj.dto.UpdateTbDiscussDto;
import com.qf.forum.proj.entity.TbDiscuss;
import com.qf.forum.proj.mapper.TbDiscussMapper;
import com.qf.forum.proj.result.Result;
import com.qf.forum.proj.result.ResultData;
import com.qf.forum.proj.service.ITbDiscussService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author FPF
 * @since 2020-11-03
 */
@Service
public class TbDiscussServiceImpl extends ServiceImpl<TbDiscussMapper, TbDiscuss> implements ITbDiscussService {

    @Autowired
    TbDiscussMapper tbDiscussMapper;
    @Override
    public List<TbDiscussDto> selectOnPage(Integer page, Integer limit) {
        return null;
    }

    @Override
    public Result updateByElement(UpdateTbDiscussDto updateTbDiscussDto) {

        try {
            String id = updateTbDiscussDto.getId();
            String filed = updateTbDiscussDto.getField();
            if ((tbDiscussMapper.selectById(id)).size() > 0) {
                if (filed.equals("title")) {
                    tbDiscussMapper.updateByTitle(id, updateTbDiscussDto.getVal());
                } else if (filed.equals("content")) {
                    filed = "CONTENT";
                    tbDiscussMapper.updateByContent(id,  updateTbDiscussDto.getVal());
                }
            }
            return new Result("11111", "success");
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new Result("0000", "error");
        }
    }

    @Override
    public Result deleteById(String[] ids) {
        if (ids.length!=0){
            for (String id:ids) {
                if ((tbDiscussMapper.selectById(id)).size()>0){
                    tbDiscussMapper.deleteById(id);
                }else {
                    return new Result("0101","请刷新试试");
                }
            }
        }
        return new Result("1111","操作成功");
    }

    @Override
    public ResultData getCount(ArrayList<String> time) {
        String[][] count=new String[7][2];

        for(int i=0;i<time.size();i++){
            int size=(tbDiscussMapper.getCount(time.get(i))).size();
          count[i][0]=time.get(i);
          count[i][1]=Integer.toString(size);
          System.out.println(time.get(i)+":"+count[i]);
        }

        return new ResultData("1111","sucess",count);
    }

    @Override
    public List<TbDiscuss> selectFive() {
        List<TbDiscuss> list=tbDiscussMapper.selectFont();
        System.out.println(list.get(1)+""+list.get(2));
        return list;
    }
}
