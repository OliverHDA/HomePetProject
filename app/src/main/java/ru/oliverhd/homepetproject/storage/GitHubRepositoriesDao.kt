package ru.oliverhd.homepetproject.storage

import androidx.room.*
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import ru.oliverhd.homepetproject.repository.GitHubRepository

@Dao
interface GitHubRepositoriesDao {

    @Query("SELECT * FROM repositories")
    fun getRepositories(): Single<List<GitHubRepository>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun retain(repositories: List<GitHubRepository>): Completable

    @Query("DELETE FROM repositories")
    fun clear (): Completable
}