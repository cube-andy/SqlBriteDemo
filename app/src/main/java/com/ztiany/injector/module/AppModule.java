package com.ztiany.injector.module;

import android.app.Application;

import com.ztiany.sqlbritedemo.AppContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * <br/>    功能描述：
 * <br/>    Email     : ztiany3@gmail.com
 *
 * @author Ztiany
 * @see
 * @since 1.0
 */

@Module
public class AppModule {

    private AppContext mAppContext;

    public AppModule(AppContext appContext) {
        mAppContext = appContext;
    }


    @Provides
    @Singleton
    Application provideAppContext() {
        return mAppContext;
    }


}
