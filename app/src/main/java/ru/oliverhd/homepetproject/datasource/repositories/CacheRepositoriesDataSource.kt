package ru.oliverhd.homepetproject.datasource.repositories

import io.reactivex.rxjava3.core.Single
import ru.oliverhd.homepetproject.repository.GitHubRepository

interface CacheRepositoriesDataSource : RepositoriesDataSource {

    fun retainRepositories(
        repositories: List<GitHubRepository>,
        url: String
    ): Single<List<GitHubRepository>>
}