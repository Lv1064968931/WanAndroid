package com.lvlin.wanandroid.lib_network.util;

import androidx.lifecycle.LiveData;

import com.lvlin.wanandroid.lib_network.bean.ApiResponse;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import retrofit2.CallAdapter;

import retrofit2.Retrofit;

public class LiveDataCallAdapterFactory extends CallAdapter.Factory {
    @Override
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        if (getRawType(returnType) != LiveData.class) {
            return null;
        }

        Type observableType = getParameterUpperBound(0, (ParameterizedType) returnType);
        Class<?> rawType = getRawType(observableType);
        boolean isResponse = true;
        if (rawType != ApiResponse.class) {
            isResponse = false;
        }

        return new LiveCallAdapter(observableType, isResponse);
    }
}
