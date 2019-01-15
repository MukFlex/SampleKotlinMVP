package com.mvp.samplekotlin.di.module

//import android.content.SharedPreferences;
//import android.preference.PreferenceManager;

import com.mvp.samplekotlin.application.MyApplication
import com.mvp.samplekotlin.data.cloud.CloudDataSource
import com.mvp.samplekotlin.data.database.LocalDatabaseSource
import com.mvp.samplekotlin.data.factory.DataSourceFactory
import com.mvp.samplekotlin.utils.prefrence.PreferenceManager

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

@Module
class AppModule(private val mMyApplication: MyApplication) {

    @Singleton
    @Provides
    internal fun provideApplication(): MyApplication {
        return mMyApplication
    }

    @Provides
    @Singleton
    internal fun provideDataSourceFactory(cloudDataSource: CloudDataSource, mCacheDataSource: LocalDatabaseSource): DataSourceFactory {
        return DataSourceFactory(cloudDataSource, mCacheDataSource)
    }

    /* @Provides
     @Singleton
     SharedPreferences provideSharedPreferences(MyApplication appContext){
         return PreferenceManager.getDefaultSharedPreferences(appContext);

     }*/
    @Provides
    @Singleton
    internal fun provideSharedPreferences(appContext: MyApplication): PreferenceManager {
        //        return PreferenceManager.getDefaultSharedPreferences(appContext);
        return PreferenceManager(appContext)
    }
}
