package ru.oliverhd.homepetproject.repository

import ru.oliverhd.homepetproject.model.GithubUser

class GithubUsersRepo {
    private val repositories = listOf(
        GithubUser("login1"),
        GithubUser("login2"),
        GithubUser("login3"),
        GithubUser("login4"),
        GithubUser("login5")
    )

    fun getUsers(): List<GithubUser> {
        return repositories
    }
     fun GetUserByLogin(login:String) : GithubUser? {
         for (githubUser in repositories){
             if (githubUser.login == login)
             return githubUser
         }
         return null
     }
}