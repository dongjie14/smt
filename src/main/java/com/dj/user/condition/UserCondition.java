package com.dj.user.condition;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by dong_jie on 2018-06-26.
 */
@ApiModel
public class UserCondition {
    @ApiModelProperty("用户名")
    private String userName;
    @ApiModelProperty("密码")
    private String passWord;
    @ApiModelProperty("年龄")
    private int age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
