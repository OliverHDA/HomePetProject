package ru.oliverhd.homepetproject.api

import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url
import ru.oliverhd.homepetproject.repository.GitHubRepository
import ru.oliverhd.homepetproject.repository.GithubUser

interface GitHubApi {

    @GET("/users")
    fun getUsers(
        @Query("since") since: Int? = null
    ): Single<List<GithubUser>>

    @GET("/users/{username}")
    fun getUserByLogin(
        @Path("username") username: String
    ): Maybe<GithubUser>

    @GET
    fun getUserRepositories(
        @Url Url: String
    ): Single<List<GitHubRepository>>
}