package ru.oliverhd.homepetproject.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.oliverhd.homepetproject.cicerone.IScreens
import ru.oliverhd.homepetproject.view.main.MainView

class MainPresenter(private val router: Router, val screens: IScreens) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.users())
    }

    fun backClicked() {
        router.exit()
    }
}