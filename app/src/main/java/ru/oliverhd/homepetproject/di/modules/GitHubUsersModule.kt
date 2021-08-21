package ru.oliverhd.homepetproject.di.modules

import dagger.Binds
import dagger.Module
import ru.oliverhd.homepetproject.datasource.remote.RemoteDataSource
import ru.oliverhd.homepetproject.datasource.remote.RemoteDataSourceImpl
import ru.oliverhd.homepetproject.datasource.repositories.CacheRepositoriesDataSource
import ru.oliverhd.homepetproject.datasource.repositories.CacheRepositoriesDataSourceImpl
import ru.oliverhd.homepetproject.datasource.users.CacheUsersDataSource
import ru.oliverhd.homepetproject.datasource.users.CacheUsersDataSourceImpl
import ru.oliverhd.homepetproject.repository.GithubUsersRepository
import ru.oliverhd.homepetproject.repository.GithubUsersRepositoryImpl
import javax.inject.Singleton

@Module
interface GitHubUsersModule {

    @Singleton
    @Binds
    fun bindGitHubUsersRepository(repository: GithubUsersRepositoryImpl): GithubUsersRepository

    @Singleton
    @Binds
    fun bindRemoteDataSource(dataSource: RemoteDataSourceImpl): RemoteDataSource

    @Singleton
    @Binds
    fun bindCacheUsersDataSource(dataSource: CacheUsersDataSourceImpl): CacheUsersDataSource

    @Singleton
    @Binds
    fun bindCacheRepositoriesDataSource(dataSource: CacheRepositoriesDataSourceImpl): CacheRepositoriesDataSource
}