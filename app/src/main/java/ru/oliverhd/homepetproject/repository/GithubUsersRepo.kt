package ru.oliverhd.homepetproject.repository

class GithubUsersRepo {
    private val users = generateUsersList()

    fun getUsers(): List<GithubUser> {
        return users
    }
     fun getUserByLogin(login:String) : GithubUser? {
         for (githubUser in users){
             if (githubUser.login == login)
             return githubUser
         }
         return null
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