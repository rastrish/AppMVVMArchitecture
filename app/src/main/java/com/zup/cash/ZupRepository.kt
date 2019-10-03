package com.zup.cash

import com.zup.cash.data.User
import com.zup.cash.data.ZupNetworkService
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ZupRepository @Inject constructor(
    private val networkService: ZupNetworkService) {

    fun login(phoneNumber: String?): Single<User> =
        networkService.login()

}