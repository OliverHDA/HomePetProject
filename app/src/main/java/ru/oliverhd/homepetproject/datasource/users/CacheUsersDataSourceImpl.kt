package ru.oliverhd.homepetproject.datasource.users

import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import ru.oliverhd.homepetproject.di.Persisted
import ru.oliverhd.homepetproject.repository.GithubUser
import ru.oliverhd.homepetproject.storage.GitHubStorage
import javax.inject.Inject

class CacheUsersDataSourceImpl @Inject constructor(
    @Persisted private val gitHubStorage: GitHubStorage
    ) : CacheUsersDataSource {

    override fun retainUsers(users: List<GithubUser>): Single<List<GithubUser>> =
        gitHubStorage.gitHubUserDao()
            .retain(users)
            .andThen(getUsers())

    override fun retainUsers(user: GithubUser): Single<GithubUser> =
        gitHubStorage.gitHubUserDao()
            .retain(user)
            .andThen(getUserByLogin(user.login).toSingle())

    override fun getUsers(): Single<List<GithubUser>> =
        gitHubStorage.gitHubUserDao().getUsers()


    override fun getUserByLogin(login: String): Maybe<GithubUser> =
        gitHubStorage.gitHubUserDao().getUserByLogin(login).toMaybe()
}