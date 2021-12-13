package com.lvlin.module_login.request;

import com.lvlin.lib_network.constant.Constant;
import com.lvlin.lib_network.util.RetrofitCreateUtil;

public class LoginRequestUtil {

    public static LoginRequest getLoginRequest() {
        return RetrofitCreateUtil.getInstance().create(Constant.BASE_URL, LoginRequest.class);
    }
}
