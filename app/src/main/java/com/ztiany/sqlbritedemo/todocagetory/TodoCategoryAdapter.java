package com.ztiany.sqlbritedemo.todocagetory;

import android.support.v7.widget.AppCompatTextView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ztiany.data.entity.TodoCategoryEntity.QueryStatisticalEntity;
import com.ztiany.sqlbritedemo.utils.UnitConverter;

import java.util.List;

/**
 * <br/>    功能描述：
 * <br/>    Email     : ztiany3@gmail.com
 *
 * @author Ztiany
 * @see
 * @since 1.0
 */

public class TodoCategoryAdapter extends BaseAdapter {
    private List<QueryStatisticalEntity> mData;

    @Override
    public int getCount() {
        return mData == null ? 0 : mData.size();
    }


    @Override
    public QueryStatisticalEntity getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            AppCompatTextView textView = new AppCompatTextView(parent.getContext());
            convertView = textView;
            int padding = UnitConverter.dpToPx(5);
            textView.setPadding(padding, padding, padding, padding);
            textView.setGravity(Gravity.CENTER);
        }
        QueryStatisticalEntity item = getItem(position);
        ((TextView) convertView)
                .setText(
                        item.name() + " count(" + item.count_TodoItem_id() + ")"
                );
        return convertView;
    }


    public void setData(List<QueryStatisticalEntity> data) {
        mData = data;
        notifyDataSetChanged();
    }
}
