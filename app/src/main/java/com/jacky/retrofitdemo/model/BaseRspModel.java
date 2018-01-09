package com.jacky.retrofitdemo.model;

import java.io.Serializable;

/**
 * Author: Jacky
 * Time：2018/1/8
 * ClassName：BaseRspModel
 * Description：基础服务器响应模型
 */

public class BaseRspModel<T> implements Serializable {
    public String returnCode;
    public T params;
    public String returnMessage;
}
