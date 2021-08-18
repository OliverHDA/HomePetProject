package ru.oliverhd.homepetproject.repository

import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import ru.oliverhd.homepetproject.datasource.remote.RemoteDataSource
import ru.oliverhd.homepetproject.datasource.repositories.CacheRepositoriesDataSource
import ru.oliverhd.homepetproject.datasource.users.CacheUsersDataSource
import javax.inject.Inject

class GithubUsersRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val cacheUsersDataSource: CacheUsersDataSource,
    private val cacheRepositoriesDataSource: CacheRepositoriesDataSource
) : GithubUsersRepository {

    override fun getUsers(): Single<List<GithubUser>> =
        cacheUsersDataSource
            .getUsers()
            .flatMap { users ->
                if (users.isEmpty()) {
                    remoteDataSource.getUsers()
                        .flatMap {
                            cacheUsersDataSource.retainUsers(it)
                        }
                } else {
                    Single.just(users)
                }
            }

    override fun getUserByLogin(login: String): Maybe<GithubUser> =
        cacheUsersDataSource
            .getUserByLogin(login)
            .switchIfEmpty(remoteDataSource.getUserByLogin(login))


    override fun getRepositories(
        url: String,
        ownerLogin: String
    ): Single<List<GitHubRepository>> =
        cacheRepositoriesDataSource
            .getRepositories(url)
            .flatMap { repositories ->
                if (repositories.isEmpty() || repositories[0].owner.login != ownerLogin) {
                    remoteDataSource.getRepositories(url)
                        .flatMap { cacheRepositoriesDataSource.retainRepositories(it, url) }
                } else {
                    Single.just(repositories)
                }
            }
}