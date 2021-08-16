package ru.oliverhd.homepetproject.datasource

import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import ru.oliverhd.homepetproject.repository.GitHubRepository
import ru.oliverhd.homepetproject.repository.GithubUser

interface DataSource {
    fun getUsers(): Single<List<GithubUser>>
    fun getUserByLogin(login: String): Maybe<GithubUser>
    fun getRepositories(url: String): Single<List<GitHubRepository>>
}