package com.dj.student.dao;

import com.dj.student.condition.SelectStudentCondition;
import com.dj.student.entity.Student;

/**
 * Created by dongjie on 2018/6/15.
 */
public interface SelectStudentDao {
    Student selectStudent(SelectStudentCondition condition);
}
