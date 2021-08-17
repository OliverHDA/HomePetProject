package ru.oliverhd.homepetproject.repository

import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface GithubUsersRepository {

    fun getUsers(): Single<List<GithubUser>>
    fun getUserByLogin(login: String): Maybe<GithubUser>
    fun getRepositories(url: String, ownerLogin: String): Single<List<GitHubRepository>>
}