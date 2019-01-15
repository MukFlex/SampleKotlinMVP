package com.mvp.samplekotlin.di.component

import com.mvp.samplekotlin.application.MyApplication
import com.mvp.samplekotlin.core.base.BaseCoreActivity
import com.mvp.samplekotlin.data.factory.DataSourceFactory
import com.mvp.samplekotlin.di.module.AppModule
import com.mvp.samplekotlin.di.module.CloudModule
import com.mvp.samplekotlin.di.module.DatabaseModule
import com.mvp.samplekotlin.utils.prefrence.PreferenceManager

import javax.inject.Singleton

import dagger.Component

@Singleton
@Component(modules = [AppModule::class, CloudModule::class, DatabaseModule::class])
interface AppComponent {
    fun app(): MyApplication

    fun dataFactory(): DataSourceFactory

    fun sharedPreferences(): PreferenceManager
    fun inject(baseActivity: BaseCoreActivity)
}
