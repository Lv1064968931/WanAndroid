package com.lvlin.wanandroid.lib_network.util;

import androidx.lifecycle.LiveData;

import com.lvlin.wanandroid.lib_network.bean.ApiResponse;

import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;

public class LiveCallAdapter<T> implements CallAdapter<T, LiveData<T>> {

    private Type mResponseType;
    private boolean isResponse;

    public LiveCallAdapter(Type mResponseType, boolean isResponse) {
        this.mResponseType = mResponseType;
        this.isResponse = isResponse;
    }

    @Override
    public Type responseType() {
        return mResponseType;
    }

    @Override
    public LiveData<T> adapt(Call<T> call) {
        return null;
    }

    private static class MyLiveData<T> extends LiveData<T> {

        private AtomicBoolean stared = new AtomicBoolean(false);
        private final Call<T> call;
        private boolean isResponse;

        public MyLiveData(Call<T> call, boolean isResponse) {
            this.call = call;
            this.isResponse = isResponse;
        }

        @Override
        protected void onActive() {
            super.onActive();
            boolean b = stared.compareAndSet(false, true);
            if(b) {
                call.enqueue(new Callback<T>() {
                    @Override
                    public void onResponse(Call<T> call, Response<T> response) {
                        T body = response.body();
                        postValue(body);
                    }

                    @Override
                    public void onFailure(Call<T> call, Throwable t) {
                        if(isResponse){
                            postValue((T) new ApiResponse<>(ApiResponse.CODE_ERROR, t.getMessage()));
                        } else {
                            postValue((T)t.getMessage());
                        }
                    }
                });
            }
        }
    }
}
