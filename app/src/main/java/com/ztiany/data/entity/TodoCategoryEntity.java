package com.ztiany.data.entity;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

/**
 * <br/>    功能描述：
 * <br/>    Email     : ztiany3@gmail.com
 *
 * @author Ztiany
 * @see
 * @since 1.0
 */

@AutoValue
public abstract class TodoCategoryEntity implements TodoCategoryModel {


    public static final Factory<TodoCategoryEntity> FACTORY = new Factory<>(
            new Creator<TodoCategoryEntity>() {
                @Override
                public TodoCategoryEntity create(long id, @NonNull String name) {
                    return new AutoValue_TodoCategoryEntity(id, name);
                }
            }
    );

    public static final Mapper<TodoCategoryEntity> MAPPER = FACTORY.queryAllMapper();

    public static final QueryStatisticalMapper<QueryStatisticalEntity> QUERY_STATISTICAL_ENTITY_QUERY_STATISTICAL_MAPPER = FACTORY.queryStatisticalMapper(
            new QueryStatisticalCreator<QueryStatisticalEntity>() {
                @Override
                public QueryStatisticalEntity create(@NonNull String name, long id, long count_TodoItem_id) {
                    return new AutoValue_TodoCategoryEntity_QueryStatisticalEntity(name, id, count_TodoItem_id);
                }
            }
    );







    @AutoValue
    public static abstract class QueryStatisticalEntity implements QueryStatisticalModel {

    }


}
