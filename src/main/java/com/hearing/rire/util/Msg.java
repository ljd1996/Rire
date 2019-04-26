package com.hearing.rire.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Create by hearing on 19-4-10
 * 消息类
 */
public class Msg implements Serializable {

    public static final int CODE_SUCCESS = 0;
    public static final int CODE_FAIL = -1;

    public static final String MSG_SUCCESS = "success";
    public static final String MSG_FAIL = "fail";

    private int code;
    private String msg;
    private Map<String, Object> extend = new HashMap<>();

    public static Msg response(int code) {
        Msg result = new Msg();
        result.setCode(code);
        result.setMsg(code == CODE_SUCCESS ? MSG_SUCCESS : MSG_FAIL);
        return result;
    }

    public static Msg response(int code, String msg) {
        Msg result = new Msg();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public Msg add(String key, Object value) {
        this.getExtend().put(key, value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
