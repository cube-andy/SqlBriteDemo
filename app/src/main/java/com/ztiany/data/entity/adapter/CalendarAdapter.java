package com.ztiany.data.entity.adapter;

import android.content.ContentValues;
import android.database.Cursor;

import com.squareup.sqldelight.ColumnAdapter;

import java.util.Calendar;

public class CalendarAdapter implements ColumnAdapter<Calendar> {

  @Override
  public Calendar map(Cursor cursor, int columnIndex) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(cursor.getLong(columnIndex));
    return calendar;
  }

  @Override
  public void marshal(ContentValues values, String key, Calendar value) {
    values.put(key, value.getTimeInMillis());
  }
}