package ru.oliverhd.homepetproject.datasource

object CacheDataSourceFactory {

    fun create(): CacheDataSource = CacheDataSourceImpl()
}