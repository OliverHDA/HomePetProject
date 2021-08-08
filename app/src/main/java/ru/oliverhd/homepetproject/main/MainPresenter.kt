package ru.oliverhd.homepetproject.main

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.oliverhd.homepetproject.userslist.UsersListScreen

class MainPresenter(private val router: Router) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(UsersListScreen.create())
    }

    fun back() = router.exit()
}