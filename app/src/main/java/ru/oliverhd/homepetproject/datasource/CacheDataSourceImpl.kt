package ru.oliverhd.homepetproject.datasource

import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import ru.oliverhd.homepetproject.repository.GitHubRepository
import ru.oliverhd.homepetproject.repository.GithubUser

class CacheDataSourceImpl : CacheDataSource {

    private val usersCache = mutableListOf<GithubUser>()
    private val repositoriesCache = mutableListOf<GitHubRepository>()

    override fun retainUsers(users: List<GithubUser>): Single<List<GithubUser>> =
        Single.fromCallable {
            usersCache.clear()
            usersCache.addAll(users)
            usersCache
        }


    override fun retainUsers(user: GithubUser): Single<GithubUser> =
        Single.fromCallable { user }

    override fun retainRepositories(repositories: List<GitHubRepository>): Single<List<GitHubRepository>> =
        Single.fromCallable {
            repositoriesCache.clear()
            repositoriesCache.addAll(repositories)
            repositoriesCache
        }

    override fun getUsers(): Single<List<GithubUser>> =
        Single.just(usersCache)


    override fun getUserByLogin(login: String): Maybe<GithubUser> {
        return usersCache.firstOrNull { user -> user.login.contentEquals(login, ignoreCase = true) }
            ?.let { user -> Maybe.just(user) }
            ?: Maybe.empty()
    }

    override fun getRepositories(url: String): Single<List<GitHubRepository>> =
        Single.just(repositoriesCache)
}