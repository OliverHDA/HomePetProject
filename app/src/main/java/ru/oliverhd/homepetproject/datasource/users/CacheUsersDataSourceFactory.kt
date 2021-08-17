package ru.oliverhd.homepetproject.datasource.users

import android.content.Context
import ru.oliverhd.homepetproject.storage.GitHubStorageFactory

object CacheUsersDataSourceFactory {

    fun create(context: Context): CacheUsersDataSource = CacheUsersDataSourceImpl(GitHubStorageFactory.create(context))
}