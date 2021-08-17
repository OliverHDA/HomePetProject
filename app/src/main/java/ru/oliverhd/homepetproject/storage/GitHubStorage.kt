package ru.oliverhd.homepetproject.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.oliverhd.homepetproject.repository.GitHubRepository
import ru.oliverhd.homepetproject.repository.GithubUser

@Database(exportSchema = false, entities = [GithubUser::class, GitHubRepository::class], version = 2)
@TypeConverters(DataConverter::class)
abstract class GitHubStorage : RoomDatabase() {

    abstract fun gitHubUserDao(): GitHubUserDao
    abstract fun gitHubRepositoriesDao(): GitHubRepositoriesDao
}