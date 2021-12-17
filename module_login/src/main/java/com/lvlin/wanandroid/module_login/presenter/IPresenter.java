package com.lvlin.wanandroid.module_login.presenter;

import com.lvlin.wanandroid.module_login.view.IView;

public interface IPresenter {
    void attachView(IView view);
    void detachView();
}
