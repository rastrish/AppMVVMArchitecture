/*
 * copyright © ZERONE MICROSYSTEMS PRIVATE LIMITED. All rights reserved.
 */

package com.zup.cash.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zup.cash.R
import com.zup.cash.utils.NetworkHelper
import com.zup.cash.utils.common.Resource
import com.zup.cash.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel(
    protected val schedulerProvider: SchedulerProvider,
    protected val compositeDisposable: CompositeDisposable,
    protected val networkHelper: NetworkHelper) : ViewModel() {

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    val messageStringId: MutableLiveData<Resource<Int>> = MutableLiveData()

    val messageString: MutableLiveData<Resource<String>> = MutableLiveData()

    protected fun checkInternetConnection(): Boolean =
        if (networkHelper.isNetworkConnected()) true
        else {
            messageStringId.postValue(Resource.error(R.string.network_connection_error))
            false
        }

    abstract fun onCreate()
}