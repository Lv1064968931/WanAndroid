package com.lvlin.module_login.view;

import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import com.lvlin.module_login.presenter.IPresenter;

public abstract class BaseActivity<P extends IPresenter> extends AppCompatActivity implements IView {
    protected P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(initLayout() instanceof Integer) {
            setContentView((Integer) initLayout());
        } else if (initLayout() instanceof View){
            setContentView((View) initLayout());
        } else {
            throw new IllegalArgumentException("initLayout()应该返回Int或者View类型对象");
        }

        mPresenter = initPresenter();
        mPresenter.attachView(this);

        create();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    /**
     * 初始化Presenter的抽象方法
     * **/
    protected abstract P initPresenter();

    /**
     * 初始化布局的抽象方法
     * **/
    protected abstract Object initLayout();

    /**
     * Activity OnCreate之后的create抽象方法
     * **/
    protected abstract void create();
}
