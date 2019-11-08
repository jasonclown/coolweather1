package com.coolweather.android;

import android.app.Application;
import android.content.Context;

import org.litepal.LitePal;

import androidx.core.content.ContextCompat;

public class Myapplication extends Application {
    private static Context mcontext;

    @Override
    public void onCreate() {
        super.onCreate();
        mcontext = getApplicationContext();
        //初始化LitePal是为了获取程序内部的context。
        // 因为要使用LitePal，就需要在配置文件的application中加入LitePal
        //但是我们自身创建的Myapplication也需要加入配置文件中，由此而导致冲突问题发生
        //于是我们就将LitePal的初始语句加入到我们自己的Myapplication中，就解决了冲突问题。
        //如果不加的话，LitePal不能获取到应用程序的context从而无法使用
        LitePal.initialize(mcontext);
    }

    public static Context getMcontext(){
        return mcontext;
    }
}
