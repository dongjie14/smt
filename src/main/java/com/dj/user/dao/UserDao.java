package com.dj.user.dao;

import com.dj.user.condition.UserCondition;
import com.dj.user.entity.User;

/**
 * Created by dong_jie on 2018-06-26.
 */
public interface UserDao {
     User selectById(int id);
     int insertUser(UserCondition userCondition);
}
