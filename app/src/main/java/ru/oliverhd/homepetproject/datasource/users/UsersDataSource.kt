package ru.oliverhd.homepetproject.datasource.users

import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import ru.oliverhd.homepetproject.repository.GitHubRepository
import ru.oliverhd.homepetproject.repository.GithubUser

interface UsersDataSource {
    fun getUsers(): Single<List<GithubUser>>
    fun getUserByLogin(login: String): Maybe<GithubUser>
}