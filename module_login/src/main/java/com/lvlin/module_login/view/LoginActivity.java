package com.lvlin.module_login.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lvlin.lib_base.RouterMap;
import com.lvlin.module_login.R;

@Route(path = RouterMap.LOGIN_ACTIVITY)
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}