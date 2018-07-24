package com.dj.umm.controller;

import com.dj.Util.MD5;
import com.dj.umm.condition.OperLoginCondition;
import com.dj.umm.entity.SysOper;
import com.dj.umm.service.SysOperService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by dong_jie on 2018-07-21.
 */
@RestController
@RequestMapping("/sysOper")
@Api(description="umm")
public class OperLoginController {

    @Autowired
    private SysOperService sysOperService;

    @GetMapping("/operLogin")
    @ApiOperation(value = "operLogin",notes = "operLogin")
    public ModelAndView operLogin(OperLoginCondition operLoginCondition){
        ModelAndView modelAndView = new ModelAndView();
        SysOper sysOper = sysOperService.queryByPhone(operLoginCondition);
        if(StringUtils.isEmpty(sysOper)){
            modelAndView.addObject("errMsg","用户不存在！");
            modelAndView.setViewName("error");
        }else{
            //判断密码错误次数，判断登录状态

            String operPhone = operLoginCondition.getOperPhone();
            String operPwd = sysOper.getOperPwd();
            String AfferentPassword = operLoginCondition.getOperPwd();
            if(MD5.checkPwd(operPhone,operPwd,AfferentPassword)){
                //更新登录状态为已登录

                modelAndView.addObject("sysOper",sysOper);
                modelAndView.setViewName("index");
            }else{
                //更新密码错误次数

                modelAndView.addObject("errMsg","密码错误！");
                modelAndView.setViewName("error");
            }
        }
        return modelAndView;
    }

}
