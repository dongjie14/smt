package com.dj.umm.controller;

import com.dj.Util.ApiErrorCode;
import com.dj.Util.EnumBusiness;
import com.dj.Util.MD5;
import com.dj.umm.condition.OperLoginCondition;
import com.dj.umm.entity.SysOper;
import com.dj.umm.service.SysOperService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户登录控制器
 * Created by dong_jie on 2018-07-21.
 */
@RestController
@RequestMapping("/sysOper")
@Api(description="umm")
public class OperLoginController {

    //最大登录失败次数
    private int PwdFailNum = 5;

    @Autowired
    private SysOperService sysOperService;

    /**
     * 根据输入手机号登录
     * @param operLoginCondition
     * @return
     */
    @GetMapping("/operLogin")
    @ApiOperation(value = "operLogin",notes = "operLogin")
    public ModelAndView operLogin(@NotNull OperLoginCondition operLoginCondition){
        ModelAndView modelAndView = new ModelAndView();
        SysOper sysOper = sysOperService.queryByPhone(operLoginCondition);
        if(StringUtils.isEmpty(sysOper)){
            modelAndView.addObject("error", ApiErrorCode.USER_NOT_EXIT);
            modelAndView.setViewName("common/error");
            return modelAndView;
        }
        int logSts = sysOper.getLogSts();
        //判断登录状态
        if(EnumBusiness.OPER_STS_LOGIN.getEnumNumber() == logSts){
            modelAndView.addObject("error", ApiErrorCode.USER_LOGIN);
            modelAndView.setViewName("common/error");
            return modelAndView;
        }
        //判断密码错误次数，判断登录状态
        int pwdFailTm = sysOper.getPwdFailTm();
        if(pwdFailTm >= PwdFailNum){
            modelAndView.addObject("error", ApiErrorCode.PASSWORD_LOCKING);
            modelAndView.setViewName("common/error");
            return modelAndView;
        }
        String operPhone = operLoginCondition.getOperPhone();
        String operPwd = sysOper.getOperPwd();
        String AfferentPassword = operLoginCondition.getOperPwd();
        if(MD5.checkPwd(operPhone,operPwd,AfferentPassword)){
            modelAndView.addObject("sysOper",sysOper);
            modelAndView.setViewName("index");
            //更新登录状态为已登录
            Map map = new HashMap();
            map.put("logSts",EnumBusiness.OPER_STS_LOGIN.getEnumNumber());
            map.put("operPhone",operPhone);
            int updNum = sysOperService.updateLogStsByPhone(map);
            if(updNum != 1){
                modelAndView.addObject("error", ApiErrorCode.UNKOWN_ERROR);
                modelAndView.setViewName("common/error");
            }
        }else{
            modelAndView.addObject("error", ApiErrorCode.PASSWORD_ERROR);
            modelAndView.setViewName("common/error");
            //更新密码错误次数
            Map map = new HashMap();
            map.put("pwdFailTm",pwdFailTm+1);
            map.put("operPhone",operPhone);
            int updNum = sysOperService.updateFailTmByPhone(map);
            if(updNum != 1){
                modelAndView.addObject("error", ApiErrorCode.UNKOWN_ERROR);
                modelAndView.setViewName("common/error");
            }
        }
        return modelAndView;
    }

}
