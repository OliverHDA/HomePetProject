package ru.oliverhd.homepetproject.storage

import android.content.Context
import androidx.room.Room
import ru.oliverhd.homepetproject.storage.migration.GitHub1to2Migration

object GitHubStorageFactory {

    fun create(context: Context): GitHubStorage =
        Room.databaseBuilder(context, GitHubStorage::class.java, "github.db")
            .addMigrations(GitHub1to2Migration)
            .build()
}