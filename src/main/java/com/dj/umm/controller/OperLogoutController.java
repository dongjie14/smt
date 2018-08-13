package com.dj.umm.controller;

import com.dj.Util.ApiErrorCode;
import com.dj.Util.EnumBusiness;
import com.dj.Util.MD5;
import com.dj.umm.condition.OperLoginCondition;
import com.dj.umm.entity.SysOper;
import com.dj.umm.service.SysOperService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户登出控制器
 * Created by dong_jie on 2018-07-24.
 */
@RestController
@RequestMapping("/sysOper")
@Api(description="umm")
public class OperLogoutController {

    @Autowired
    private SysOperService sysOperService;

    /**
     * 根据手机号登出
     * @param operPhone
     * @return
     */
    @GetMapping("/operLogout")
    @ApiOperation(value = "operLogout",notes = "operLogout")
    public ModelAndView operLogout(@NotNull String operPhone){
        ModelAndView modelAndView = new ModelAndView();Map map = new HashMap();
        map.put("logSts",EnumBusiness.OPER_STS_LOGOUT.getEnumNumber());
        map.put("operPhone",operPhone);
        int updNum = sysOperService.updateLogStsByPhone(map);
        if(updNum != 1){
            modelAndView.addObject("error", ApiErrorCode.UNKOWN_ERROR);
            modelAndView.setViewName("common/error");
        }
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
