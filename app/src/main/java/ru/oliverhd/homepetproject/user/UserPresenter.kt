package ru.oliverhd.homepetproject.user

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.oliverhd.homepetproject.repository.GithubUsersRepo
import ru.oliverhd.homepetproject.userslist.UsersListScreen

class UserPresenter (private val userLogin: String, private val usersRepo: GithubUsersRepo, private val router: Router): MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        val user = usersRepo.getUserByLogin(userLogin)
        if (user != null) {
            viewState.showUserLogin(user.login)
        }
    }

    fun click(): Boolean {
        router.backTo(UsersListScreen.create())
        return false
    }
}