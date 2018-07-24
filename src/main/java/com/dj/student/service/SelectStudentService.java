package com.dj.student.service;

import com.dj.common.annotation.ReadDataSource;
import com.dj.student.condition.SelectStudentCondition;
import com.dj.student.dao.SelectStudentDao;
import com.dj.student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dongjie on 2018/6/15.
 */
@Service("selectTestService")
public class SelectStudentService {

    @Autowired
    private SelectStudentDao selectStudentDao;

    @ReadDataSource
    public Student selectStudent(SelectStudentCondition condition){
        return selectStudentDao.selectStudent(condition);
    }
}
