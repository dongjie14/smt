package com.dj.user.controller;


import com.dj.user.condition.UserCondition;
import com.dj.user.entity.User;
import com.dj.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by dong_jie on 2018-06-26.
 */
@RestController
@RequestMapping("${adminPath}/user")
@Api(description="User")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/selectById")
    @ApiOperation(value = "selectById",notes = "selectById")
    public User selectById(int id) throws IOException {
        return userService.selectById(id);
    }

    @PostMapping("/insertUser")
    @ApiOperation(value = "新增用户",notes = "新增用户")
    public void insertUser(UserCondition userCondition){
        int i = userService.insertUser(userCondition);
        return;
    }
}

