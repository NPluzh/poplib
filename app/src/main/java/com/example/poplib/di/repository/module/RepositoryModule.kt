package com.example.poplib.di.repository.module

import com.example.poplib.di.repository.RepositoryScope
import com.example.poplib.mvp.model.api.IDataSource
import com.example.poplib.mvp.model.cache.IGithubRepositoriesCache
import com.example.poplib.mvp.model.cache.room.RoomGithubRepositoriesCache
import com.example.poplib.mvp.model.entity.room.Database
import com.example.poplib.mvp.model.network.INetworkStatus
import com.example.poplib.mvp.model.repo.IGithubRepositoriesRepo
import com.example.poplib.mvp.model.repo.retrofit.RetrofitGithubRepositoriesRepo
import dagger.Module
import dagger.Provides

@Module
open class RepositoryModule {

    @Provides
    fun repositoriesCache(database: Database): IGithubRepositoriesCache {
        return RoomGithubRepositoriesCache(database)
    }

    @RepositoryScope
    @Provides
    fun repositoriesRepo(api: IDataSource, networkStatus: INetworkStatus, cache: IGithubRepositoriesCache): IGithubRepositoriesRepo {
        return RetrofitGithubRepositoriesRepo(api, networkStatus, cache)
    }
}