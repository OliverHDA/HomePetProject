package ru.oliverhd.homepetproject.repository

object GithubUsersRepositoryFactory {

    fun create(): GithubUsersRepository = GithubUsersRepositoryImpl()
}