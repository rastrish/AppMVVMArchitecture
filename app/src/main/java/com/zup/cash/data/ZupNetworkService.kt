package com.zup.cash.data

import io.reactivex.Single
import retrofit2.http.POST
import javax.inject.Singleton

@Singleton
interface ZupNetworkService {

    @POST("login/mindorks")
    fun login():Single<User>
}