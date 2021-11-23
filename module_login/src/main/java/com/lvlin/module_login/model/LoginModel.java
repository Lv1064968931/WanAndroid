package com.lvlin.module_login.model;

import com.lvlin.module_login.bean.UserBean;
import com.lvlin.module_login.contract.LoginContract;

public class LoginModel implements IModel, LoginContract.ILoginModel {
    @Override
    public void doLogin(UserBean param, LoginCallBack loginCallBack) {

    }
}
