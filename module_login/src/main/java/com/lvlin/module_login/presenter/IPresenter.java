package com.lvlin.module_login.presenter;

import com.lvlin.module_login.view.IView;

public interface IPresenter {
    void attachView(IView view);
    void detachView();
}
