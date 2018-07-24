package com.dj.Util;

/**
 * Created by dong_jie on 2018-06-28.
 */
public enum ApiErrorCode {
    UNKOWN_ERROR(100,"未知异常"),
    INVALID_PARAMETER(102,"参数非法"),
    SUCCESS(200,"成功"),
    FAIL(300,"失败");

    ApiErrorCode(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    private int code;

    private String msg;

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

}
