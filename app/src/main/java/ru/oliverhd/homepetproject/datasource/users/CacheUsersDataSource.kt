package ru.oliverhd.homepetproject.datasource.users

import io.reactivex.rxjava3.core.Single
import ru.oliverhd.homepetproject.repository.GithubUser

interface CacheUsersDataSource : UsersDataSource {

    fun retainUsers(users: List<GithubUser>): Single<List<GithubUser>>
    fun retainUsers(user: GithubUser): Single<GithubUser>
}