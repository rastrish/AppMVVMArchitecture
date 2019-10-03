package com.zup.cash.di.module

import androidx.lifecycle.ViewModelProviders
import com.zup.cash.ZupRepository
import com.zup.cash.ui.base.BaseActivity
import com.zup.cash.ui.main.MainViewModel
import com.zup.cash.ui.splash.SplashViewModel
import com.zup.cash.utils.NetworkHelper
import com.zup.cash.utils.ViewModelProviderFactory
import com.zup.cash.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @Provides
    fun provideSplashViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        zupRepository: ZupRepository
    ): SplashViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(SplashViewModel::class) {
            SplashViewModel(schedulerProvider,compositeDisposable, networkHelper, zupRepository)
        }).get(SplashViewModel::class.java)

    @Provides
    fun provideMainViewModel(schedulerProvider: SchedulerProvider,compositeDisposable: CompositeDisposable,
                             networkHelper: NetworkHelper,zupRepository: ZupRepository):MainViewModel =
        ViewModelProviders.of(activity,
        ViewModelProviderFactory(MainViewModel::class){MainViewModel(schedulerProvider,compositeDisposable,
            networkHelper,zupRepository)}).get(MainViewModel::class.java)
}