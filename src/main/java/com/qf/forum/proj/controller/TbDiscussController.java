package com.qf.forum.proj.controller;


import com.qf.forum.proj.dto.UpdateTbDiscussDto;
import com.qf.forum.proj.entity.TbDiscuss;
import com.qf.forum.proj.mapper.TbDiscussMapper;
import com.qf.forum.proj.result.Result;
import com.qf.forum.proj.result.ResultData;
import com.qf.forum.proj.service.ITbDiscussService;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author FPF
 * @since 2020-11-03
 */
@RestController
@RequestMapping("tbDiscuss")


public class TbDiscussController {

    @Autowired
    ITbDiscussService iTbDiscussService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public void selectOnPage(Integer page, Integer limit){
        System.out.println(page+""+limit);

      // return tbDiscussMapper.selectAll();
    }

    @RequestMapping(value = "/updateByElement",method = RequestMethod.PATCH)
    public Result updateByElement(@RequestBody UpdateTbDiscussDto updateTbDiscussDto){
       return iTbDiscussService.updateByElement(updateTbDiscussDto);
    }

    @RequestMapping(value = "/deleteById",method = RequestMethod.DELETE)
    public Result deleteById(@RequestBody String[] ids){
       // return iTbDiscussService.deleteById(ids);
        return null;
    }

    @RequestMapping(value = "/getRecentlyTb",method = RequestMethod.POST)
    public Result getRecentlyTb() {

        Date date=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String result = sdf.format(date);
        ArrayList<String> list=TbDiscussController.pastDay(result);
        return  iTbDiscussService.getCount(list);
    }

    public static String getPastDate(int past,Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - past);
        Date today = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String result = sdf.format(today);
        return result;
    }
//前七天
    public static ArrayList<String> pastDay(String time){
        ArrayList<String> pastDaysList = new ArrayList<>();
        try {
            //我这里传来的时间是个string类型的，所以要先转为date类型的。
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(time);
            for (int i = 6; i >= 0; i--) {
                pastDaysList.add(getPastDate(i,date));
            }
        }catch (ParseException e){
            e.printStackTrace();
        }
        return pastDaysList;
    }

    @RequestMapping(value = "/selectFive",method = RequestMethod.POST)
    public ResultData selectFive(){
        return   new ResultData("1111","success",iTbDiscussService.selectFive())    ;
    }
}

