package ru.oliverhd.homepetproject.cicerone

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.oliverhd.homepetproject.view.user.UserFragment
import ru.oliverhd.homepetproject.view.users.UsersFragment

interface IScreens {
    fun users(): Screen
    fun user(userLogin: String): Screen
}

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
    override fun user(userLogin: String) = FragmentScreen { UserFragment.newInstance(userLogin) }
}