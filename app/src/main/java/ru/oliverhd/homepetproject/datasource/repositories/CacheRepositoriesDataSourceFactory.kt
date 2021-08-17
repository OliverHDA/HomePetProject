package ru.oliverhd.homepetproject.datasource.repositories

import android.content.Context
import ru.oliverhd.homepetproject.storage.GitHubStorageFactory

object CacheRepositoriesDataSourceFactory {

    fun create(context: Context): CacheRepositoriesDataSource =
        CacheRepositoriesDataSourceImpl(GitHubStorageFactory.create(context))
}