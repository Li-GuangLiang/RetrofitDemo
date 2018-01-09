package com.jacky.retrofitdemo.model;

import java.io.Serializable;

/**
 * Author: Jacky
 * Time：2018/1/5
 * ClassName：AccountRspModel
 * Description：服务器账号登录返回数据模型
 */

public class AccountRspModel implements Serializable {
    /**
     * idenStatus : 9
     * birthday : yyyy-MM-dd
     * sex : 0
     * username : 15574888564
     * headImg :
     * authKey : 071948287b634621a1621c1359f199b4
     * email :
     * nickname : 小暖(｡･ω･｡)
     * volunteer : 0
     * utype : 1
     * servCode : 1002
     * mobile :
     */

    public int idenStatus;
    public String birthday;
    public int sex;
    public String username;
    public String headImg;
    public String authKey;
    public String email;
    public String nickname;
    public int volunteer;
    public int utype;
    public int servCode;
    public String mobile;
}
