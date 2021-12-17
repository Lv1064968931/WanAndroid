package com.lvlin.wanandroid.module_login.presenter;

import com.lvlin.wanandroid.module_login.bean.UserBean;
import com.lvlin.wanandroid.module_login.contract.LoginContract;
import com.lvlin.wanandroid.module_login.model.LoginModel;
import com.lvlin.wanandroid.module_login.view.LoginActivity;

public class LoginPresenter extends BasePresenter<LoginActivity, LoginModel> implements LoginContract.ILoginPresenter {
    @Override
    public void getLoginData(UserBean param) {
        mView.showLoading();

        mModel.doLogin(param, new LoginContract.ILoginModel.LoginCallBack() {
            @Override
            public void onSuccess(UserBean data) {
                mView.showLoginSuccess(data);
            }

            @Override
            public void onFailure(String data) {
                mView.showFailureMessage(data);
            }

            @Override
            public void onError(String error) {
                mView.showErrorMessage(error);
            }

            @Override
            public void onComplete() {
                mView.hideLoading();
            }
        });

    }

    @Override
    protected LoginModel initModel() {
        return new LoginModel();
    }
}
