package com.ztiany.sqlbritedemo;

import android.app.Application;

import com.ztiany.injector.component.AppComponent;
import com.ztiany.injector.component.DaggerAppComponent;
import com.ztiany.injector.module.AppModule;
import com.ztiany.sqlbritedemo.utils.BaseUtils;

/**
 * <br/>    功能描述：
 * <br/>    Email     : ztiany3@gmail.com
 *
 * @author Ztiany
 * @see
 * @since 1.0
 */

public class AppContext extends Application {

    private static AppContext sAppContext;
    private static  AppComponent mAppComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        sAppContext = this;
        BaseUtils.init(this);

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }




    public static AppContext getAppContext() {
        return sAppContext;
    }


    public  static AppComponent getAppComponent() {
        return mAppComponent;
    }
}
