package com.dj.Util;

/**
 * Created by dong_jie on 2018-06-28.
 */
public enum ApiErrorCode {
    UNKOWN_ERROR(100,"未知异常"),
    INVALID_PARAMETER(102,"参数非法"),
    SUCCESS(200,"成功"),
    FAIL(300,"失败"),
    USER_NOT_EXIT(301,"用户不存在！"),
    USER_LOGIN(302,"用户已登录！"),
    PASSWORD_ERROR(303,"密码错误！"),
    PASSWORD_LOCKING(304,"密码已被锁定，请联系系统管理员！");

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
