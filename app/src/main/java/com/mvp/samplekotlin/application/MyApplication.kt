package com.mvp.samplekotlin.application

import android.app.Application
import com.mvp.samplekotlin.di.component.AppComponent
import com.mvp.samplekotlin.di.component.DaggerAppComponent
import com.mvp.samplekotlin.di.module.AppModule
import com.mvp.samplekotlin.di.module.CloudModule

class MyApplication: Application() {
    private  val TAG = MyApplication::class.java.name
    private lateinit var mAppComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        initializeInjector()
    }

    private fun initializeInjector() {
        this.mAppComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))

//                                .cloudModule( CloudModule())
                //                .databaseModule(DatabaseModule())
                .build()
    }

    fun getAppComponent(): AppComponent {
                   initializeInjector()

        return mAppComponent
    }
}