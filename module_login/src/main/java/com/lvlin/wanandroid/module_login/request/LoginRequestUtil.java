package com.lvlin.wanandroid.module_login.request;

import com.lvlin.wanandroid.lib_network.constant.Constant;
import com.lvlin.wanandroid.lib_network.util.RetrofitCreateUtil;

public class LoginRequestUtil {

    public static LoginRequest getLoginRequest() {
        return RetrofitCreateUtil.getInstance().create(Constant.BASE_URL, LoginRequest.class);
    }
}
