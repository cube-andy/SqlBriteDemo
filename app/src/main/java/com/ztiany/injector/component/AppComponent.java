package com.ztiany.injector.component;

import android.app.Application;

import com.ztiany.injector.module.AppModule;
import com.ztiany.injector.module.DbModule;
import com.ztiany.sqlbritedemo.todocagetory.CreateCategoryFragment;
import com.ztiany.sqlbritedemo.todocagetory.TodoCategoryFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * <br/>    功能描述：
 * <br/>    Email     : ztiany3@gmail.com
 *
 * @author Ztiany
 * @see
 * @since 1.0
 */
@Singleton
@Component(modules = {
        AppModule.class,
        DbModule.class
})
public interface AppComponent {

    Application provideAppContext();

    void inject(TodoCategoryFragment todoFragment);

    void inject(CreateCategoryFragment createCategoryFragment);
}
