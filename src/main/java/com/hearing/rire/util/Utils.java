package com.hearing.rire.util;

import org.springframework.util.ClassUtils;

/**
 * Create by hearing on 19-4-13
 */
public class Utils {
    public static String getResPath() {
        return ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/file/";
    }
}
