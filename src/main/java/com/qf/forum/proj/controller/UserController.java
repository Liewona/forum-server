package com.qf.forum.proj.controller;

import com.qf.forum.config.aspect.annotation.LoginCheck;
import com.qf.forum.proj.dto.UserDto;
import com.qf.forum.proj.dto.EditDto;
import com.qf.forum.proj.entity.Account;
import com.qf.forum.proj.result.ResultData;
import com.qf.forum.proj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @LoginCheck
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ResultData getUserList(HttpServletRequest request, Integer page, Integer limit){
        return userService.getUserList(page,limit);
    }

    @LoginCheck
    @RequestMapping(value = "/like",method = RequestMethod.GET)
    public ResultData getUserListLike(HttpServletRequest request,String uname,String phone,Integer page,Integer limit){
        return userService.like(uname,phone,page,limit);
    }

    @LoginCheck
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResultData addUser(HttpServletRequest request,@RequestBody UserDto userDto){
        System.out.println(userDto.getUsername());
        boolean flag = userService.registe(userDto);
        if (flag){
            return new ResultData("200","新增成功",null);
        }
        return new ResultData("000","新增失败",null);
    }

    @LoginCheck
    @RequestMapping(value = "/",method = RequestMethod.DELETE)
    public ResultData deleteUser(HttpServletRequest request,@RequestBody String[] ids){
        for(String id:ids){
            userService.delete(id);
        }
        return new ResultData("200","删除成功",null);

    }

    @LoginCheck
    @RequestMapping(value = "/",method = RequestMethod.PATCH)
    public ResultData updateUser(HttpServletRequest request,@RequestBody EditDto userEditDto){
        return userService.update(userEditDto);
    }

    @LoginCheck
    @RequestMapping(value = "/twoCondition",method = RequestMethod.PATCH)
    public ResultData updateByTwo(HttpServletRequest request,@RequestBody UserDto userDto){
        return userService.updateByTwo(userDto);
    }

    @RequestMapping(value = "/userInfo" ,method =  RequestMethod.GET)
    public ResultData getInfo(HttpServletRequest request,@RequestParam Integer userId){
        return  userService.selectUserDtoById(userId);
    }
   // @LoginCheck
    @RequestMapping(value = "/updateInfo" ,method = RequestMethod.POST)
    public ResultData updateInfo(HttpServletRequest request ,@RequestBody UserDto userDto){
        return userService.updateByPrimaryKeySelective(userDto);
    }
    @RequestMapping(value = "/updateAccount" ,method = RequestMethod.POST)
    public ResultData updateAccount(HttpServletRequest request ,@RequestBody Account account){
        return userService.updateAccount(account);
    }

    @RequestMapping("upload")
    @ResponseBody
    public Map<String, Object> uploadToUser(@RequestParam("file") MultipartFile file) {
        Map<String, Object> map = new HashMap<>();
        FileOutputStream out = null;
        try {
            String fileName = file.getOriginalFilename();
            if (fileName.indexOf("\\") != -1) {
                fileName = fileName.substring(fileName.lastIndexOf("\\"));
            }
            // 获取文件存放地址
            String filePath = "E://Personal code//huRry//forum-server//src//main//resources//static//img//";
            File f = new File(filePath);
            if (!f.exists()) {
                f.mkdirs();// 不存在路径则进行创建
            }
            // 重新自定义文件的名称
            filePath = filePath + fileName;
            out = new FileOutputStream(filePath);
            out.write(file.getBytes());
            out.flush();
            out.close();
            map.put("fileName", fileName);
            Thread.sleep(10000);
            return map;
        } catch (Exception e) {
            map.clear();
            map.put("2", "error");
            return map;
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
