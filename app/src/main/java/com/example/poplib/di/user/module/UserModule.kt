package com.example.poplib.di.user.module

import com.example.poplib.di.user.UserScope
import com.example.poplib.mvp.model.api.IDataSource
import com.example.poplib.mvp.model.cache.IGithubUsersCache
import com.example.poplib.mvp.model.cache.room.RoomGithubUsersCache
import com.example.poplib.mvp.model.entity.room.Database
import com.example.poplib.mvp.model.network.INetworkStatus
import com.example.poplib.mvp.model.repo.IGithubUsersRepo
import com.example.poplib.mvp.model.repo.retrofit.RetrofitGithubUsersRepo
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Module
open class UserModule {

    @Provides
    fun usersCache(database: Database): IGithubUsersCache {
        return RoomGithubUsersCache(database)
    }


    @UserScope
    @Provides
    open fun usersRepo(api: IDataSource, networkStatus: INetworkStatus, cache: IGithubUsersCache): IGithubUsersRepo {
        return RetrofitGithubUsersRepo(api, networkStatus, cache)
    }
}