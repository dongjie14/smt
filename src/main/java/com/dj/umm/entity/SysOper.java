package com.dj.umm.entity;

import java.io.Serializable;
import java.util.Date;

public class SysOper implements Serializable {

    private Integer id;

    private String operNm;

    private String operPhone;

    private String operEmail;

    private String operPwd;

    private Integer operType;

    private Date lastLogTm;

    private Integer logSts;

    private Integer pwdFailTm;

    private Date createTm;

    private String createOper;

    private Date updateTm;

    private String updateOper;

    private Date tmSmp;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperNm() {
        return operNm;
    }

    public void setOperNm(String operNm) {
        this.operNm = operNm == null ? null : operNm.trim();
    }

    public String getOperPhone() {
        return operPhone;
    }

    public void setOperPhone(String operPhone) {
        this.operPhone = operPhone;
    }

    public String getOperEmail() {
        return operEmail;
    }

    public void setOperEmail(String operEmail) {
        this.operEmail = operEmail == null ? null : operEmail.trim();
    }

    public String getOperPwd() {
        return operPwd;
    }

    public void setOperPwd(String operPwd) {
        this.operPwd = operPwd == null ? null : operPwd.trim();
    }

    public Integer getOperType() {
        return operType;
    }

    public void setOperType(Integer operType) {
        this.operType = operType;
    }

    public Date getLastLogTm() {
        return lastLogTm;
    }

    public void setLastLogTm(Date lastLogTm) {
        this.lastLogTm = lastLogTm;
    }

    public Integer getLogSts() {
        return logSts;
    }

    public void setLogSts(Integer logSts) {
        this.logSts = logSts;
    }

    public Integer getPwdFailTm() {
        return pwdFailTm;
    }

    public void setPwdFailTm(Integer pwdFailTm) {
        this.pwdFailTm = pwdFailTm;
    }

    public Date getCreateTm() {
        return createTm;
    }

    public void setCreateTm(Date createTm) {
        this.createTm = createTm;
    }

    public String getCreateOper() {
        return createOper;
    }

    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
    }

    public Date getUpdateTm() {
        return updateTm;
    }

    public void setUpdateTm(Date updateTm) {
        this.updateTm = updateTm;
    }

    public String getUpdateOper() {
        return updateOper;
    }

    public void setUpdateOper(String updateOper) {
        this.updateOper = updateOper == null ? null : updateOper.trim();
    }

    public Date getTmSmp() {
        return tmSmp;
    }

    public void setTmSmp(Date tmSmp) {
        this.tmSmp = tmSmp;
    }
}