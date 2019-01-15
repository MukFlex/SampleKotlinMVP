package com.mvp.samplekotlin.di.component

import com.mvp.samplekotlin.di.module.CloudModule

import javax.inject.Singleton

import dagger.Component


@Singleton
@Component(modules = [CloudModule::class])
interface CloudComponent

