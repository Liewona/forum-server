package com.qf.forum.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.util.ResourceBundle;

/*
 *   Author = Liewona
 *   Date = 2020/11/3 17:03
 */
public class StringUtils {

    public static final String UP_PATH;
    public static final String IMG_SERVER;
    public static final String SESSION_KEY;


    private StringUtils() { }

    static {
        ResourceBundle resource = ResourceBundle.getBundle("properties/string");
        UP_PATH = resource.getString("up-path");
        IMG_SERVER =  resource.getString("img-server");
        SESSION_KEY = resource.getString("session-key");

    }

}
