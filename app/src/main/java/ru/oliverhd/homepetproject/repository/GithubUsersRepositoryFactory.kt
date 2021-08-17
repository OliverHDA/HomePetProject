package ru.oliverhd.homepetproject.repository

import android.content.Context
import ru.oliverhd.homepetproject.datasource.users.CacheUsersDataSourceFactory
import ru.oliverhd.homepetproject.datasource.remote.RemoteDataSourceFactory
import ru.oliverhd.homepetproject.datasource.repositories.CacheRepositoriesDataSourceFactory

object GithubUsersRepositoryFactory {

    fun create(context: Context): GithubUsersRepository = GithubUsersRepositoryImpl(
        RemoteDataSourceFactory.create(),
        CacheUsersDataSourceFactory.create(context),
        CacheRepositoriesDataSourceFactory.create(context)
    )
}