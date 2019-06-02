package com.rental.common;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public class Result implements Serializable {
    public static final int SUCCESS = 1;
    public static final int ERROR = 0;

    private int code;
    private String msg;
    private Object data;

    public Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result build(int code, String msg, Object data) {
        return new Result(code, msg, data);
    }

    public static Result ok(String msg, Object data) {
        return new Result(SUCCESS, msg, data);
    }

    public static Result ok(String msg) {
        return new Result(SUCCESS, msg, null);
    }

    public static Result ok(Object data) {
        return new Result(SUCCESS, "success", data);
    }

    public static Result fail(String msg, Object data) {
        return new Result(ERROR, msg, data);
    }

    public static Result fail(String msg) {
        return new Result(ERROR, msg, null);
    }

    public static Result fail(Object data) {
        return new Result(ERROR, "server error", data);
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static String genResponse(Result result) {
        return JSON.toJSONString(result);
    }
}
