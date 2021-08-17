package ru.oliverhd.homepetproject.datasource.remote

import ru.oliverhd.homepetproject.api.GitHubApiFactory
import ru.oliverhd.homepetproject.datasource.users.UsersDataSource

object RemoteDataSourceFactory {

    fun create(): RemoteDataSource = RemoteDataSourceImpl(GitHubApiFactory.create())
}