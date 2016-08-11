package com.ztiany.data.entity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;
import com.squareup.sqldelight.RowMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * <br/>    功能描述：
 * <br/>    Email     : ztiany3@gmail.com
 *
 * @author Ztiany
 * @see
 * @since 1.0
 */

@AutoValue
public abstract class BookEntity implements BookModel {


    private static final Factory<BookEntity> FACTORY = new Factory<>(
            new Creator<BookEntity>() {
                @Override
                public BookEntity create(long id, @NonNull String bookName, @NonNull String author, @NonNull String domain) {
                    return new AutoValue_BookEntity(id, bookName, author, domain);
                }
            }
    );


    private static final RowMapper<BookEntity> ALL_MAPPER = FACTORY.select_allMapper();

    public static List<BookEntity> allBooks(SQLiteDatabase db) {
        List<BookEntity> names = new ArrayList<>();
        Cursor cursor = db.rawQuery(SELECT_ALL,null);
        try {
            while (cursor.moveToNext()) {
                names.add(ALL_MAPPER.map(cursor));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            cursor.close();
        }
        return names;
    }

}
