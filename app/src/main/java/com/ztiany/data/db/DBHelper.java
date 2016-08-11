package com.ztiany.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.ztiany.data.entity.BookModel;
import com.ztiany.data.entity.FriendModel;
import com.ztiany.data.entity.TodoCategoryModel;
import com.ztiany.data.entity.TodoItemModel;


/**
 * <br/>    功能描述：
 * <br/>    Email     : ztiany3@gmail.com
 *
 * @author Ztiany
 * @see
 * @since 1.0
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String TAG = DBHelper.class.getSimpleName();

    private static final int VERSION = 1;
    private static final String DB_NAME = "demo.db";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(BookModel.CREATE_TABLE);
        sqLiteDatabase.execSQL(FriendModel.CREATE_TABLE);
        sqLiteDatabase.execSQL(TodoCategoryModel.CREATE_TABLE);
        sqLiteDatabase.execSQL(TodoItemModel.CREATE_TABLE);

        Log.d(TAG, BookModel.CREATE_TABLE);
        Log.d(TAG, FriendModel.CREATE_TABLE);
        Log.d(TAG, TodoCategoryModel.CREATE_TABLE);
        Log.d(TAG, TodoItemModel.CREATE_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
