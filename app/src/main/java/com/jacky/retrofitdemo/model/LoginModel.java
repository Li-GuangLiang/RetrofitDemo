package com.jacky.retrofitdemo.model;

/**
 * Author: Jacky
 * Time：2018/1/5
 * ClassName：LoginModel
 * Description：
 */

public class LoginModel {
    private String account;//用户名
    private String pwd;//密码
    private int loginType;//登录类型：1普通登录 2手机免密 3第三方登录 4会员信息刷新

    /**
     * 普通登录
     *
     * @param account   用户名
     * @param pwd       密码
     * @param loginType 登录类型：1普通登录
     */
    public LoginModel(String account, String pwd, int loginType) {
        this.account = account;
        this.pwd = pwd;
        this.loginType = loginType;
    }

    /**
     * 手机免密登录
     *
     * @param account   用户名
     * @param loginType 登录类型： 2手机免密
     */
    public LoginModel(String account, int loginType) {
        this.account = account;
        this.loginType = loginType;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getLoginType() {
        return loginType;
    }

    public void setLoginType(int loginType) {
        this.loginType = loginType;
    }
}
