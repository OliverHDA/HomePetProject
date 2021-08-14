package ru.oliverhd.homepetproject.userslist

import ru.oliverhd.homepetproject.repository.GithubUser

data class GithubUserViewModel(val login: String) {

    object Mapper {

        fun map(user: GithubUser) =
            GithubUserViewModel(user.login.uppercase())
    }
}