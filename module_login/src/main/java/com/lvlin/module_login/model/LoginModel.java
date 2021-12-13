package com.lvlin.module_login.model;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LifecycleObserver;

import com.lvlin.lib_network.bean.ApiResponse;
import com.lvlin.module_login.bean.UserBean;
import com.lvlin.module_login.contract.LoginContract;
import com.lvlin.module_login.request.LoginRequestUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;

public class LoginModel implements IModel, LoginContract.ILoginModel, LifecycleObserver {

    private Handler handler;

    public LoginModel() {
        handler = new Handler(Looper.getMainLooper());
    }

    @SuppressLint("CheckResult")
    @Override
    public void doLogin(UserBean param, LoginCallBack loginCallBack) {

        LoginRequestUtil.getLoginRequest().login(param.getUsername(), param.getPassword())
                .subscribeOn(Schedulers.io())//运行在io线程
                .observeOn(AndroidSchedulers.mainThread())//回调在主线程
                .subscribeWith(new ResourceSubscriber<ApiResponse<UserBean>>() {
                    @Override
                    public void onNext(ApiResponse<UserBean> userBeanApiResponse) {
                        param.setToken("登录成功");
                        loginCallBack.onSuccess(param);
                    }

                    @Override
                    public void onError(Throwable t) {
                        loginCallBack.onError("网络异常");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
