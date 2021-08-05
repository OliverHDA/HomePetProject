package ru.oliverhd.homepetproject.cicerone

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.oliverhd.homepetproject.view.UsersFragment

interface IScreens {
    fun users(): Screen
}

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
}