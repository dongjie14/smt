package com.dj.student.condition;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by dongjie on 2018/6/19.
 */
@ApiModel
public class SelectStudentCondition {
    @ApiModelProperty("姓名")
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
