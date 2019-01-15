package com.mvp.samplekotlin.di.component

import com.mvp.samplekotlin.di.module.CloudModule
import com.mvp.samplekotlin.di.module.DatabaseModule

import javax.inject.Singleton

import dagger.Component

@Singleton
@Component(modules = [DatabaseModule::class])
interface DatabaseComponent
