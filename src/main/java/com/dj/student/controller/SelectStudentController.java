package com.dj.student.controller;

import com.dj.student.condition.SelectStudentCondition;
import com.dj.student.entity.Student;
import com.dj.student.service.SelectStudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dongjie on 2018/6/14.
 */
@RestController
@RequestMapping("/${adminPath}/student")
@Api(description="Test")
public class SelectStudentController {

    @Autowired
    private SelectStudentService selectStudentService;

    @GetMapping("/Query")
    @ApiOperation(value="QryStudent", notes="QryStudent")
    public Student QryStudent(SelectStudentCondition condition){
        return selectStudentService.selectStudent(condition);
    }

}
