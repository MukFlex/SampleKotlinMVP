package com.mvp.samplekotlin.di.module

import android.app.Activity

import com.mvp.samplekotlin.data.factory.DataSourceFactory
import com.mvp.samplekotlin.di.PerActivity
import com.mvp.samplekotlin.mvp.presenter.LoginPresenter
import com.mvp.samplekotlin.mvp.presenter.LoginPresenterImpl

import dagger.Module
import dagger.Provides

@Module
class PresenterModule {
    //    DataSourceFactory dataSource;
    //    Activity context;


    @Provides
    @PerActivity
    internal fun provideLoginPresenterImpl(dataSource: DataSourceFactory, context: Activity): LoginPresenter {
        return LoginPresenterImpl(dataSource, context)
    }


}
