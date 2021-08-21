package ru.oliverhd.homepetproject.datasource.remote

import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import ru.oliverhd.homepetproject.api.GitHubApi
import ru.oliverhd.homepetproject.repository.GitHubRepository
import ru.oliverhd.homepetproject.repository.GithubUser
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val gitHubApi: GitHubApi) :
    RemoteDataSource {

    override fun getUsers(): Single<List<GithubUser>> =
        gitHubApi.getUsers()

    override fun getUserByLogin(login: String): Maybe<GithubUser> = gitHubApi.getUserByLogin(login)

    override fun getRepositories(url: String): Single<List<GitHubRepository>> =
        gitHubApi.getUserRepositories(url)
}