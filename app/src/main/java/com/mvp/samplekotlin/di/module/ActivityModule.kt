package com.mvp.samplekotlin.di.module

import android.app.Activity

import com.mvp.samplekotlin.di.PerActivity

import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: Activity) {

    @PerActivity
    @Provides
    internal fun providerActivity(): Activity {
        return activity
    }
}
