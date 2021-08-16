package ru.oliverhd.homepetproject.datasource

import ru.oliverhd.homepetproject.api.GitHubApiFactory

object RemoteDataSourceFactory {

    fun create(): DataSource = RemoteDataSourceImpl(GitHubApiFactory.create())
}