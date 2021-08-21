package ru.oliverhd.homepetproject.repository

import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import ru.oliverhd.homepetproject.datasource.CacheDataSource
import ru.oliverhd.homepetproject.datasource.DataSource

class GithubUsersRepositoryImpl(
    private val remoteDataSource: DataSource,
    private val cacheDataSource: CacheDataSource
) : GithubUsersRepository {

    override fun getUsers(): Single<List<GithubUser>> {
        return cacheDataSource
            .getUsers()
            .flatMap { users ->
                if (users.isEmpty()) {
                    remoteDataSource.getUsers()
                        .flatMap{
                            cacheDataSource.retainUsers(it)}
                } else {
                    Single.just(users)
                }
            }
    }

    override fun getUserByLogin(login: String): Maybe<GithubUser> {
        return cacheDataSource
            .getUserByLogin(login)
            .switchIfEmpty(remoteDataSource.getUserByLogin(login))
    }

    override fun getRepositories(url: String): Single<List<GitHubRepository>> {
        return cacheDataSource
            .getRepositories(url)
            .flatMap { repositories ->
                if (repositories.isEmpty()) {
                    remoteDataSource.getRepositories(url)
                        .flatMap(
                            cacheDataSource::retainRepositories
                        )
                } else {
                    Single.just(repositories)
                }
            }
    }
}