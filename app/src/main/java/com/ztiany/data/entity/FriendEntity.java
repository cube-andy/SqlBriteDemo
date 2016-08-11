package com.ztiany.data.entity;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.ztiany.data.entity.adapter.CalendarAdapter;

import java.util.Calendar;

/**
 * <br/>    功能描述：
 * <br/>    Email     : ztiany3@gmail.com
 *
 * @author Ztiany
 * @see
 * @since 1.0
 */

@AutoValue
public abstract class FriendEntity implements FriendModel {

    private static final Factory<FriendEntity> FACTORY = new Factory<>(
            new Creator<FriendEntity>() {
                @Override
                public FriendEntity create(long id, @NonNull String name, @NonNull String city, @Nullable Calendar age) {
                    return new AutoValue_FriendEntity(id, name, city, age);
                }
            }, new CalendarAdapter()
    );


}
