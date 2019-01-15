package com.mvp.samplekotlin.di.component

import android.app.Activity

import com.mvp.samplekotlin.di.PerActivity
import com.mvp.samplekotlin.di.module.ActivityModule
import com.mvp.samplekotlin.di.module.AppModule

import dagger.Component

@PerActivity
@Component(modules = [ActivityModule::class], dependencies = [AppComponent::class])
interface ActivityComponent {
    fun activity(): Activity
}
