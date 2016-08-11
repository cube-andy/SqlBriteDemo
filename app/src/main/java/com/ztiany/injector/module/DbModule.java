package com.ztiany.injector.module;

import android.app.Application;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.HandlerThread;
import android.util.Log;

import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;
import com.ztiany.data.db.DBHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.android.schedulers.AndroidSchedulers;
import timber.log.Timber;

/**
 * <br/>    功能描述：
 * <br/>    Email     : ztiany3@gmail.com
 *
 * @author Ztiany
 * @see
 * @since 1.0
 */
@Module
public class DbModule {

    private static final String TAG = DbModule.class.getSimpleName();
    @Provides
    @Singleton
    SQLiteOpenHelper provideOpenHelper(Application application) {
        Log.d(TAG, "provideOpenHelper() called with: application = [" + application + "]");
        return new DBHelper(application);
    }

    @Provides
    @Singleton
    SqlBrite provideSqlBrite() {
        Log.d(TAG, "provideSqlBrite() called");
        return SqlBrite.create(new SqlBrite.Logger() {
            @Override
            public void log(String message) {
                Timber.tag("Database").v(message);
            }
        });
    }

    @Provides
    @Singleton
    BriteDatabase provideDatabase(SqlBrite sqlBrite, SQLiteOpenHelper helper) {
        Log.d(TAG, "provideDatabase() called with: sqlBrite = [" + sqlBrite + "], helper = [" + helper + "]");
        HandlerThread handlerThread = new HandlerThread("db thread");
        handlerThread.start();

        BriteDatabase db = sqlBrite.wrapDatabaseHelper(helper, AndroidSchedulers.from(
                handlerThread.getLooper()
        ));

        db.setLoggingEnabled(true);
        return db;
    }
}
