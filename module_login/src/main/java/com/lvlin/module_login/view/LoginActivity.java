package com.lvlin.module_login.view;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lvlin.lib_base.RouterMap;
import com.lvlin.module_login.R;
import com.lvlin.module_login.bean.UserBean;
import com.lvlin.module_login.contract.LoginContract;
import com.lvlin.module_login.presenter.LoginPresenter;

@Route(path = RouterMap.LOGIN_ACTIVITY)
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.ILoginView {

    private EditText userNameEt;
    private EditText passwordEt;
    private Button loginBtn;

    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected Object initLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void create() {
        userNameEt = findViewById(R.id.user_name_et);
        passwordEt = findViewById(R.id.password_et);
        loginBtn = findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    @Override
    public void showLoading() {
        Toast.makeText(LoginActivity.this, "showLoading", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideLoading() {
        Toast.makeText(LoginActivity.this, "hideLoading", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginSuccess(UserBean userBean) {
        Toast.makeText(LoginActivity.this, "showLoginSuccess userName=" + userBean.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailureMessage(String message) {
        Toast.makeText(LoginActivity.this, "showFailureMessage msg=" + message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(LoginActivity.this, "showErrorMessage msg=" + message, Toast.LENGTH_SHORT).show();
    }

    public void login() {
        UserBean userBean = new UserBean();
        userBean.setUsername(userNameEt.getText().toString().trim());
        userBean.setPassword(passwordEt.getText().toString().trim());

        mPresenter.getLoginData(userBean);
    }
}