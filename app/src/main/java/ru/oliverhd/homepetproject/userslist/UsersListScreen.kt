package ru.oliverhd.homepetproject.userslist

import com.github.terrakok.cicerone.androidx.FragmentScreen

object UsersListScreen {

    fun create() = FragmentScreen { UsersListFragment.newInstance() }
}