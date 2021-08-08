package ru.oliverhd.homepetproject.repository

import io.reactivex.rxjava3.core.Single

class GithubUsersRepo {
    private val users = generateUsersList()

    fun getUsers(): Single<List<GithubUser>> {
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