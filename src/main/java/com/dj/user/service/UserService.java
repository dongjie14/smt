package com.dj.user.service;

import com.dj.common.annotation.ReadDataSource;
import com.dj.common.annotation.WriteDataSource;
import com.dj.user.condition.UserCondition;
import com.dj.user.dao.UserDao;
import com.dj.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dong_jie on 2018-06-26.
 */
@Service("userService")
public class UserService {

    @Autowired
    private UserDao userDao;

    @ReadDataSource
    public User selectById(int id){
        return userDao.selectById(id);
    }

    @WriteDataSource
    public int insertUser(UserCondition userCondition){
        return userDao.insertUser(userCondition);
    }
}
