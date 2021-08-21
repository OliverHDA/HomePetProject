package ru.oliverhd.homepetproject.datasource

import io.reactivex.rxjava3.core.Single
import ru.oliverhd.homepetproject.repository.GitHubRepository
import ru.oliverhd.homepetproject.repository.GithubUser

interface CacheDataSource : DataSource {

    fun retainUsers(users: List<GithubUser>): Single<List<GithubUser>>
    fun retainUsers(user: GithubUser): Single<GithubUser>
    fun retainRepositories(repositories: List<GitHubRepository>): Single<List<GitHubRepository>>
}