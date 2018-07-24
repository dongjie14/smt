package com.dj.umm.controller;

import com.dj.umm.entity.SysOper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotNull;

/**
 * Created by dong_jie on 2018-07-24.
 */
@RestController
@RequestMapping
public class HeaderController {

    /**
     * 公共头部分控制器
     * @return
     */
    @GetMapping("/header")
    public ModelAndView header(@NotNull String operNm,@NotNull String operPhone, String operEmail, int operType){
        ModelAndView modelAndView = new ModelAndView();
        SysOper sysOper = new SysOper();
        sysOper.setOperNm(operNm);
        sysOper.setOperPhone(operPhone);
        sysOper.setOperEmail(operEmail);
        sysOper.setOperType(operType);
        modelAndView.addObject("sysOper",sysOper);
        modelAndView.setViewName("common/header");
        return modelAndView;
    }

}
