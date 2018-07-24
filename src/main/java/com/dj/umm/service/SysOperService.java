package com.dj.umm.service;

import com.dj.common.annotation.ReadDataSource;
import com.dj.common.annotation.WriteDataSource;
import com.dj.umm.condition.OperLoginCondition;
import com.dj.umm.dao.SysOperDao;
import com.dj.umm.entity.SysOper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dong_jie on 2018-07-21.
 */
@Service("sysOperService")
public class SysOperService {

    @Autowired
    private SysOperDao sysOperDao;

    @ReadDataSource
    public SysOper queryByPhone(OperLoginCondition operLoginCondition){
        return sysOperDao.queryByPhone(operLoginCondition);
    }

    @WriteDataSource
    public int updateLogStsByPhone(String operPhone){
        return sysOperDao.updateLogStsByPhone(operPhone);
    }

    @WriteDataSource
    public int updateFailTmByPhone(String operPhone){
        return sysOperDao.updateFailTmByPhone(operPhone);
    }

}
