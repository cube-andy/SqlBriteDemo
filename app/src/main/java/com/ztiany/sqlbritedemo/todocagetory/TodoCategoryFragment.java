package com.ztiany.sqlbritedemo.todocagetory;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.trello.rxlifecycle.FragmentEvent;
import com.trello.rxlifecycle.components.support.RxFragment;
import com.ztiany.data.entity.TodoCategoryEntity;
import com.ztiany.sqlbritedemo.AppContext;
import com.ztiany.sqlbritedemo.R;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * <br/>    功能描述：
 * <br/>    Email     : ztiany3@gmail.com
 *
 * @author Ztiany
 * @see
 * @since 1.0
 */

public class TodoCategoryFragment extends RxFragment {


    @BindView(R.id.frag_home_list)
    ListView mListView;
    @BindView(R.id.frag_home_empty)
    Button mButton;

    private View mLayoutView;
    private TodoCategoryAdapter mTodoCategoryAdapter;

    @Inject
    TodoItemsModel mTodoItemsModel;

    public static TodoCategoryFragment newInstance() {
        return new TodoCategoryFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppContext.getAppComponent().inject(this);
        setHasOptionsMenu(true);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        MenuItem newCategory = menu.add("newCategory");
        MenuItemCompat.setShowAsAction(newCategory, MenuItemCompat.SHOW_AS_ACTION_ALWAYS);
        newCategory.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
               CreateCategoryFragment.newInstance()
                        .show(getChildFragmentManager(), CreateCategoryFragment.class.getName());
                return true;
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mLayoutView == null) {
            mLayoutView = inflater.inflate(R.layout.fragment_todo_category, container, false);
            ButterKnife.bind(this, mLayoutView);
            setupView();
        }

        return mLayoutView;

    }

    private void setupView() {
        mListView.setEmptyView(mButton);
        mTodoCategoryAdapter = new TodoCategoryAdapter();
        mListView.setAdapter(mTodoCategoryAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadData();
    }

    private void loadData() {
        mTodoItemsModel.getTodoList()
                .compose(this.<List<TodoCategoryEntity.QueryStatisticalEntity>>bindUntilEvent(FragmentEvent.DESTROY))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<TodoCategoryEntity.QueryStatisticalEntity>>() {
                    @Override
                    public void call(List<TodoCategoryEntity.QueryStatisticalEntity> queryStatisticalEntities) {
                        mTodoCategoryAdapter.setData(queryStatisticalEntities);
                    }
                });
    }
}
