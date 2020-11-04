package com.qf.forum.config.aspect.annotation;

/*
 *   Author = Liewona
 *   Date = 2020/11/3 22:28
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginCheck {

}
