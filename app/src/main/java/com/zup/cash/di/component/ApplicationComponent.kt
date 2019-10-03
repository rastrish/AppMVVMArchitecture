package com.zup.cash.di.component

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.zup.cash.ZupApplication
import com.zup.cash.ZupRepository
import com.zup.cash.data.ZupNetworkService
import com.zup.cash.di.ApplicationContext
import com.zup.cash.di.module.ApplicationModule
import com.zup.cash.utils.NetworkHelper
import com.zup.cash.utils.rx.SchedulerProvider
import dagger.Component
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(app: ZupApplication)

    fun getApplication(): Application

    @ApplicationContext
    fun getContext(): Context

    fun getSharedPreferences(): SharedPreferences

    fun getNetworkHelper(): NetworkHelper

    fun getUserRepository(): ZupRepository

    fun getSchedulerProvider(): SchedulerProvider

    fun getCompositeDisposable(): CompositeDisposable

    fun getZupNetworkService():ZupNetworkService
}