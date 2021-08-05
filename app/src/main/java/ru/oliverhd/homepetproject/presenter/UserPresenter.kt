package ru.oliverhd.homepetproject.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.oliverhd.homepetproject.cicerone.IScreens
import ru.oliverhd.homepetproject.repository.GithubUsersRepo
import ru.oliverhd.homepetproject.view.user.UserView

class UserPresenter (private val usersRepo: GithubUsersRepo, private val router: Router, val screens: IScreens): MvpPresenter<UserView>() {
    fun setUserLogin(userLogin: String) {
        val user = usersRepo.GetUserByLogin(userLogin)
        if (user != null) {
            viewState.showUserLogin(user.login)
        }
    }

    fun backClick(): Boolean {
        router.backTo(screens.users())
        return false
    }
}