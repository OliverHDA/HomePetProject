package ru.oliverhd.homepetproject.user

import com.github.terrakok.cicerone.androidx.FragmentScreen

class UserScreen(private val login: String) {

    fun create() = FragmentScreen { UserFragment.newInstance(login) }
}