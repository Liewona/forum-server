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


    private StringUtils() { }

    static {
        ResourceBundle resource = ResourceBundle.getBundle("resources/string");
        UP_PATH = resource.getString("up-path");

    }

}
