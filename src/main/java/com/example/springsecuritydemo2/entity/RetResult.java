package com.example.springsecuritydemo2.entity;

public class RetResult {

    private boolean success = true;

    private int code = 0;

    private String msg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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

    public RetResult(){};

    public RetResult(boolean success, int code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }

    public static RetResult create(int code, String msg) {
        RetResult retResult = new RetResult(false, code, msg);
        return retResult;
    }

    public static final RetResult successResult = new RetResult();

}
