package com.jacky.retrofitdemo.net;


import com.jacky.retrofitdemo.model.AccountRspModel;
import com.jacky.retrofitdemo.model.BaseRspModel;
import com.jacky.retrofitdemo.model.LoginModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Author: Jacky
 * Time：2018/1/8
 * ClassName：ApiService
 * Description：所有的网络请求接口
 */

public interface ApiService {
    /**
     * 1001
     * 会员登录接口
     *
     * @param model LoginModel
     * @return BaseRspModel<AccountRspModel>
     */
    @POST("entry.do?servCode=1001&srcCode=1")
    Call<BaseRspModel<AccountRspModel>> accountLogin(@Body LoginModel model);
}
