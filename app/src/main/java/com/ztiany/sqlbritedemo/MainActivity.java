package com.ztiany.sqlbritedemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.ztiany.sqlbritedemo.home.HomeFragment;
import com.ztiany.sqlbritedemo.todocagetory.TodoCategoryFragment;

public class MainActivity extends AppCompatActivity
        implements HomeFragment.HomeFragmentCallback {

    private static final int TODO = 1;
    private static final int BOOKS = 2;
    private static final int FRIENDS = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.activity_main, HomeFragment.newInstance(), HomeFragment.class.getName())
                    .commit();
        }
    }


    @Override
    public void showBookList() {

    }

    @Override
    public void showFriendList() {

    }

    @Override
    public void showTodoList() {

        switchFragment(TODO);
    }


    private void switchFragment(int page) {
        Fragment fragment = createFragment(page);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_main, fragment, fragment.getClass().getName())
                .commit();
    }

    private Fragment createFragment(int page) {
        switch (page) {
            case TODO: {
                return TodoCategoryFragment.newInstance();
            }
            case BOOKS: {
                return null;
            }
            case FRIENDS: {
                return null;

            }
            default: {
                throw new IllegalArgumentException();
            }
        }


    }


}
