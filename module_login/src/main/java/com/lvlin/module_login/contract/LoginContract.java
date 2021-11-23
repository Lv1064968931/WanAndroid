package com.lvlin.module_login.contract;

import com.lvlin.module_login.bean.UserBean;

public class LoginContract {


    /**
     * 登录Model
     * **/
    public interface ILoginModel {

        /**
         * 登陆操作
         *
         * @param param 用户数据
         **/
        void doLogin(UserBean param, LoginCallBack loginCallBack);

        interface LoginCallBack {

            /**
             * 登录成功
             *
             * @param data 返回数据
             * **/
            void onSuccess(UserBean data);

            /**
             * 调用登陆接口时，接口调用成功但是因
             * 用户名错误，登陆失效等后台控制逻辑导致的登陆失败
             *
             * @param data 失败原因
             * **/
            void onFailure(String data);

            /**
             * 接口调用失败
             * 网络不通
             * 接口超时
             * 404、500等原因
             *
             * @param error 失败原因
             * **/
            void onError(String error);

            /**
             * 接口请求结束，包括上面三种情况
             * 设置此方法通常是进行hideLoading等操作
             * **/
            void onComplete();
        }
    }

    /**
     * 登录View
     * **/
    public interface ILoginView {
        void showLoading();

        void hideLoading();

        /**
         * 登录成功
         *
         * @param userBean 用户类
         * **/
        void showLoginSuccess(UserBean userBean);

        /**
         * 显示登录失败信息
         *
         * @param message 失败信息
         * **/
        void showFailureMessage(String message);

        /**
         * 显示登录错误信息
         *
         * @param message 错误信息
         * **/
        void showErrorMessage(String message);
    }

    /**
     * 登录presenter
     *
     * **/
    public interface ILoginPresenter{
        /**
         * 获取登录数据
         *
         * @param param 用户类
         * **/
        void getLoginData(UserBean param);
    }

}
