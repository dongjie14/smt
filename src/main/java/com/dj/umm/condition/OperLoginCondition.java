package com.dj.umm.condition;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by dong_jie on 2018-07-23.
 */
@ApiModel
public class OperLoginCondition {
    @ApiModelProperty("操作员手机号")
    private String operPhone;
    @ApiModelProperty("操作员密码")
    private String operPwd;

    public String getOperPhone() {
        return operPhone;
    }

    public void setOperPhone(String operPhone) {
        this.operPhone = operPhone;
    }

    public String getOperPwd() {
        return operPwd;
    }

    public void setOperPwd(String operPwd) {
        this.operPwd = operPwd;
    }
}
