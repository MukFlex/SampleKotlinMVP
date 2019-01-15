package com.mvp.samplekotlin.di.component

import com.mvp.samplekotlin.view.activity.LoginActivity
import com.mvp.samplekotlin.di.PerActivity
import com.mvp.samplekotlin.di.module.ActivityModule
import com.mvp.samplekotlin.di.module.PresenterModule

import dagger.Component


@PerActivity
@Component(modules = [ActivityModule::class, PresenterModule::class], dependencies = [AppComponent::class])
interface PresenterComponent {
    fun inject(loginActivity: LoginActivity)
}
