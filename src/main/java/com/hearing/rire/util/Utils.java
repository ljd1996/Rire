package com.hearing.rire.util;

import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Create by hearing on 19-4-13
 */
public class Utils {

    /**
     * 获取图片和文件的路径
     * @return
     */
    public static String getResPath() {
//        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/file/";
        String path = "E:/lilan/file/";
        File f = new File(path);
        if (!f.exists()) {
            f.mkdirs();
        }
        System.out.println("path = " + path);
        return path;
    }

    /**
     * 将用户上传的文件放到服务器中（此处为本地）
     * @param file
     * @return
     * @throws IOException
     */
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

    /**
     * 删除List后面的元素，只留下count个元素
     * @param list
     * @param count
     */
    public static void rmBack(List<?> list, int count) {
        if (list.size() > count) {
            for (int i = list.size() - 1; i >= count; i--) {
                list.remove(i);
            }
        }
    }
}
