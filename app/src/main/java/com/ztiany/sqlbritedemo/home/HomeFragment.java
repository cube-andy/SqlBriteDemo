package com.ztiany.sqlbritedemo.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ztiany.sqlbritedemo.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * <br/>    功能描述：
 * <br/>    Email     : ztiany3@gmail.com
 *
 * @author Ztiany
 * @see
 * @since 1.0
 */

public class HomeFragment extends Fragment {


    private View mLayoutView;


    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (!(getContext() instanceof HomeFragmentCallback)) {
            throw new RuntimeException("context need impl HomeFragmentCallback ");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mLayoutView == null) {
            mLayoutView = inflater.inflate(R.layout.fragment_home, container, false);
            ButterKnife.bind(this, mLayoutView);
        }
        return mLayoutView;
    }


    @OnClick(value = {
            R.id.frag_home_todo,
            R.id.frag_home_friends,
            R.id.frag_home_books
    }
    )
    void onClickView(View view) {
        HomeFragmentCallback fragmentCallback = (HomeFragmentCallback) getContext();
        switch (view.getId()) {
            case R.id.frag_home_todo: {
                fragmentCallback.showTodoList();
                break;
            }
            case R.id.frag_home_friends: {
                fragmentCallback.showFriendList();
                break;
            }
            case R.id.frag_home_books: {
                fragmentCallback.showBookList();

                break;
            }
        }
    }


    public interface HomeFragmentCallback {
        void showBookList();

        void showFriendList();

        void showTodoList();

    }

}
