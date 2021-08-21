package ru.oliverhd.homepetproject.repository

import ru.oliverhd.homepetproject.datasource.CacheDataSourceFactory
import ru.oliverhd.homepetproject.datasource.RemoteDataSourceFactory

object GithubUsersRepositoryFactory {

    fun create(): GithubUsersRepository = GithubUsersRepositoryImpl(RemoteDataSourceFactory.create(), CacheDataSourceFactory.create())
}