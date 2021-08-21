package ru.oliverhd.homepetproject.main

import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import moxy.MvpPresenter

class MainPresenter(
    private val router: Router,
    private val usersListScreen: FragmentScreen
) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(usersListScreen)
    }

    fun back() = router.exit()
}