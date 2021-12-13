package com.lvlin.module_login.request;

import androidx.lifecycle.LiveData;

import com.lvlin.lib_network.bean.ApiResponse;
import com.lvlin.module_login.bean.UserBean;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LoginRequest {

    @FormUrlEncoded
    @POST("user/login")
    Flowable<ApiResponse<UserBean>> login(@Field("username") String username, @Field("password") String password);


    @FormUrlEncoded
    @POST("user/register")
    Flowable<ApiResponse<UserBean>> register(@Field("username") String username, @Field("password") String password, @Field("repassword") String repassword);

    @GET("user/logout/json")
    Flowable<ApiResponse>logout();
}
