package ru.oliverhd.homepetproject.repository

import io.reactivex.rxjava3.core.Single

interface GithubUsersRepository {

    fun getUsers(): Single<List<GithubUser>>
}