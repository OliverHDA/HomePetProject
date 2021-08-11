package ru.oliverhd.homepetproject.repository

import io.reactivex.rxjava3.core.Single

class GithubUsersRepositoryImpl: GithubUsersRepository {
    private val users = generateUsersList()

    override fun getUsers(): Single<List<GithubUser>> {
        return Single.just(users)
    }

    private fun generateUsersList(): List<GithubUser> {
        val usersList = mutableListOf<GithubUser>()
        for(i in 1..100){
            usersList.add(GithubUser(
                "login$i"))
        }
        return usersList
    }
}