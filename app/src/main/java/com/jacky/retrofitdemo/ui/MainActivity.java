package com.jacky.retrofitdemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jacky.retrofitdemo.R;
import com.jacky.retrofitdemo.model.AccountRspModel;
import com.jacky.retrofitdemo.model.BaseRspModel;
import com.jacky.retrofitdemo.model.LoginModel;
import com.jacky.retrofitdemo.net.ApiService;
import com.jacky.retrofitdemo.net.Network;
import com.jacky.retrofitdemo.utils.ConstantsConfig;
import com.jacky.retrofitdemo.utils.LogUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnPost = findViewById(R.id.btn_post);
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginModel loginModel = new LoginModel("15574888564", "1472580", 1);
                //调用Retrofit对网络请求接口进行代理
                ApiService apiService = Network.agent(ConstantsConfig.API_BASE_URL);
                // 得到一个Call
                Call<BaseRspModel<AccountRspModel>> call = apiService.accountLogin(loginModel);
                //进行异步网络请求
                call.enqueue(new Callback<BaseRspModel<AccountRspModel>>() {
                    @Override
                    public void onResponse(Call<BaseRspModel<AccountRspModel>> call, Response<BaseRspModel<AccountRspModel>> response) {
                        BaseRspModel<AccountRspModel> accountRspModel = response.body();
                        assert accountRspModel != null;
                        LogUtils.d("onResponse--->", accountRspModel.returnMessage);
                        Toast.makeText(MainActivity.this, "onResponse" + accountRspModel.returnMessage, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<BaseRspModel<AccountRspModel>> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "onFailure" + t.getMessage(), Toast.LENGTH_SHORT).show();
                        LogUtils.d("onFailure--->", t.getMessage());
                    }
                });
            }
        });
    }
}
