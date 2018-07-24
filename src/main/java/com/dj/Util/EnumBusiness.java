package com.dj.Util;

/**
 * 业务枚举值
 * Created by dong_jie on 2018-07-24.
 */
public enum EnumBusiness {
    OPER_TYPE_SYSTEM_OPER(0,"系统管理员"),
    OPER_TYPE_ORDINARY_OPER(1,"普通管理员"),
    OPER_STS_LOGOUT(0,"未登录"),
    OPER_STS_LOGIN(1,"已登录");

    EnumBusiness(int enumNumber, String enumInterpretation){
        this.enumNumber = enumNumber;
        this.enumInterpretation = enumInterpretation;
    }
    private int enumNumber;

    private String enumInterpretation;

    public int getEnumNumber() {
        return enumNumber;
    }

    public void setEnumNumber(int enumNumber) {
        this.enumNumber = enumNumber;
    }

    public String getEnumInterpretation() {
        return enumInterpretation;
    }

    public void setEnumInterpretation(String enumInterpretation) {
        this.enumInterpretation = enumInterpretation;
    }
}