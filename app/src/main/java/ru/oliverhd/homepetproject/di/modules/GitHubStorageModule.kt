package ru.oliverhd.homepetproject.di.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.oliverhd.homepetproject.di.InMemory
import ru.oliverhd.homepetproject.di.Persisted
import ru.oliverhd.homepetproject.storage.GitHubStorage
import ru.oliverhd.homepetproject.storage.migration.GitHub1to2Migration

@Module
class GitHubStorageModule {

    @Persisted
    @Provides
    fun provideGitHubDatabaseStorage(context: Context) =
        Room.databaseBuilder(context, GitHubStorage::class.java, "github.db")
            .addMigrations(GitHub1to2Migration)
            .build()

    @InMemory
    @Provides
    fun provideGitHubMemoryStorage(context: Context) =
        Room.inMemoryDatabaseBuilder(context, GitHubStorage::class.java)
            .addMigrations(GitHub1to2Migration)
            .build()
}