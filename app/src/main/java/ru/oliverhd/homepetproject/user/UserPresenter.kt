package ru.oliverhd.homepetproject.user

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpPresenter
import ru.oliverhd.homepetproject.repository.GithubUser
import ru.oliverhd.homepetproject.repository.GithubUsersRepo
import ru.oliverhd.homepetproject.userslist.UsersListScreen

class UserPresenter(
    private val userLogin: String,
    private val usersRepo: GithubUsersRepo,
    private val router: Router
) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        usersRepo
            .getUsers()
            .subscribe(object : SingleObserver<List<GithubUser>> {
                var disposable: Disposable? = null
                override fun onSubscribe(d: Disposable?) {
                    disposable = d
                }

                override fun onSuccess(t: List<GithubUser>?) {
                    t?.let {
                        for (githubUser in t) {
                            if (githubUser.login == userLogin)
                                viewState.showUserLogin(githubUser.login)
                        }
                    }
                }

                override fun onError(e: Throwable?) {
                    TODO("Not yet implemented")
                }
            })
    }

    fun click(): Boolean {
        router.backTo(UsersListScreen.create())
        return false
    }
}