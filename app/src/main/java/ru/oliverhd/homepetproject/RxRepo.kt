package ru.oliverhd.homepetproject

import io.reactivex.rxjava3.core.Single
import ru.oliverhd.homepetproject.repository.GitHubRepository

object RxRepo {

    private var repo: GitHubRepository? = null

    fun setRepo(repos: GitHubRepository) {
        repo = repos
    }

    fun getRxRepo () : Single<GitHubRepository> = Single.just(repo)
}