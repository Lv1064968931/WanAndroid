package com.lvlin.module_login.presenter;

import com.lvlin.module_login.model.IModel;
import com.lvlin.module_login.view.IView;

public abstract class BasePresenter<V extends IView, M extends IModel> implements IPresenter {

    protected V mView;
    protected M mModel;

    public BasePresenter() {
        mModel = initModel();
    }

    @Override
    public void attachView(IView view) {
        mView = (V) view;
    }

    @Override
    public void detachView() {
        mView = null;
        mModel = null;
    }

    protected abstract M initModel();
}
