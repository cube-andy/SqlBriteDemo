package com.ztiany.sqlbritedemo.todocagetory;

import android.database.Cursor;

import com.squareup.sqlbrite.BriteDatabase;
import com.ztiany.data.entity.TodoCategoryEntity;
import com.ztiany.data.entity.TodoCategoryModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

import static com.ztiany.data.entity.TodoCategoryEntity.*;

/**
 * <br/>    功能描述：
 * <br/>    Email     : ztiany3@gmail.com
 *
 * @author Ztiany
 * @see
 * @since 1.0
 */
class TodoItemsModel {


    BriteDatabase mBriteDatabase;

    @Inject
    TodoItemsModel(BriteDatabase database) {
        mBriteDatabase = database;
    }


    Observable<List<QueryStatisticalEntity>> getTodoList() {
        ArrayList<String> tables = new ArrayList<>(Arrays.asList(TodoCategoryEntity.TABLE_NAME, TodoCategoryModel.TABLE_NAME));
        return mBriteDatabase.createQuery(
                tables
                , TodoCategoryEntity.QUERYSTATISTICAL
        ).mapToList(new Func1<Cursor, QueryStatisticalEntity>() {
            @Override
            public QueryStatisticalEntity call(Cursor cursor) {
                return TodoCategoryEntity.QUERY_STATISTICAL_ENTITY_QUERY_STATISTICAL_MAPPER.map(cursor);
            }
        });
    }


}
