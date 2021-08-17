package ru.oliverhd.homepetproject.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import ru.oliverhd.homepetproject.repository.GithubUser

@Dao
interface GitHubUserDao {

    @Query("SELECT * FROM github_users")
    fun getUsers(): Single<List<GithubUser>>

    @Query("SELECT * FROM github_users WHERE login LIKE :login COLLATE NOCASE LIMIT 1")
    fun getUserByLogin (login: String): Single<GithubUser>

    @Insert(onConflict = REPLACE)
    fun retain(users: List<GithubUser>): Completable

    @Update(onConflict = REPLACE)
    fun retain(user: GithubUser): Completable
}