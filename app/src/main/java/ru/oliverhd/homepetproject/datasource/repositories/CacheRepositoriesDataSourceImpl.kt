package ru.oliverhd.homepetproject.datasource.repositories

import io.reactivex.rxjava3.core.Single
import ru.oliverhd.homepetproject.repository.GitHubRepository
import ru.oliverhd.homepetproject.storage.GitHubStorage

class CacheRepositoriesDataSourceImpl(private val gitHubStorage: GitHubStorage) :
    CacheRepositoriesDataSource {

    override fun retainRepositories(
        repositories: List<GitHubRepository>,
        url: String
    ): Single<List<GitHubRepository>> =
        gitHubStorage
            .gitHubRepositoriesDao()
            .clear()
            .andThen(gitHubStorage
                .gitHubRepositoriesDao()
                .retain(repositories))
            .andThen(getRepositories(url))

    override fun getRepositories(url: String): Single<List<GitHubRepository>> =
        gitHubStorage.gitHubRepositoriesDao().getRepositories()
}