package com.qf.forum.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Md5Util {
    public static String  getMd5(String account,String password){
        Md5Hash md5Hash = new Md5Hash(password,account,1000);
        return md5Hash.toString();
    }
}
