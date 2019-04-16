package com.hearing.rire.util;

import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create by hearing on 19-4-13
 */
public class Utils {
    public static String getResPath() {
        return ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/file/";
    }

    public static String getImgPath(MultipartFile file) throws IOException {
        if (file == null || file.getOriginalFilename().isEmpty()) {
            return null;
        }
        String name = file.getOriginalFilename();
        String preffix = name.substring(0, name.lastIndexOf("."));
        String subffix = name.substring(name.lastIndexOf("."), name.length());
        long time = new Date().getTime();
        String fileName = preffix + new SimpleDateFormat("yyyyMMddHHmmss").format(time) + subffix;
        String filepath = Utils.getResPath();

        File f = new File(filepath);
        if (!f.exists()) {
            f.mkdirs();
        }
        f = new File(filepath + fileName);
        f.createNewFile();
        file.transferTo(f);
        return filepath + fileName;
    }
}
