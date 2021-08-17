package ru.oliverhd.homepetproject.datasource.repositories

import io.reactivex.rxjava3.core.Single
import ru.oliverhd.homepetproject.repository.GitHubRepository

interface RepositoriesDataSource {

    fun getRepositories(url: String): Single<List<GitHubRepository>>
}