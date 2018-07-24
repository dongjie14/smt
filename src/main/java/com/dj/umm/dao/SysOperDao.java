package com.dj.umm.dao;

import com.dj.umm.condition.OperLoginCondition;
import com.dj.umm.entity.SysOper;

import java.util.Map;

/**
 * Created by dong_jie on 2018-07-21.
 */
public interface SysOperDao {
    SysOper queryByPhone(OperLoginCondition operLoginCondition);

    int updateLogStsByPhone(Map map);

    int updateFailTmByPhone(Map map);

}
