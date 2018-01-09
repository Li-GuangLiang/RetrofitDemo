package com.jacky.retrofitdemo.utils;

/**
 * Author: Jacky
 * Time：2018/1/5
 * ClassName：ConstantsConfig
 * Description：通用常量、参数配置
 */

public class ConstantsConfig {
    public static final String API_BASE_URL = "http://www.wanjingtai.com/api/app/wda/v2/";
    public static final String API_BASE_URL_V3 = "http://www.wanjingtai.com/api/app/wda/v3/entry.do?";
    /**
     * LogUtils日志工具类开关
     * 1:打印日志 6:屏蔽日志
     */
    public static final int isRelease = 1;
    /**
     * OkHttp拦截器标识
     */
    public static final String interceptorTag = "Wjt-Wda";
    /**
     * OkHttp拦截器开关
     * true:打印日志 false:屏蔽日志
     */
    public static final boolean isPrintOkHttpLog = true;
}
