package ru.oliverhd.homepetproject.user

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpPresenter
import ru.oliverhd.homepetproject.repository.GithubUsersRepository
import ru.oliverhd.homepetproject.userslist.GithubUserViewModel
import ru.oliverhd.homepetproject.userslist.GithubUserViewModel.Mapper
import ru.oliverhd.homepetproject.userslist.UsersListScreen

class UserPresenter(
    private val userLogin: String,
    private val usersRepository: GithubUsersRepository,
    private val router: Router
) : MvpPresenter<UserView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        usersRepository
            .getUsers()
            .map { users -> users.map(Mapper::map) }
            .subscribe(object : SingleObserver<List<GithubUserViewModel>> {

                override fun onSubscribe(d: Disposable?) {
                    disposables.add(d)
                }

                override fun onSuccess(t: List<GithubUserViewModel>?) {
                    t?.let {
                        for (githubUser in t) {
                            if (githubUser.login == userLogin)
                                viewState.showUserLogin(githubUser.login)
                        }
                    }
                }

                override fun onError(e: Throwable?) {
                    e?.let {
                        viewState.error(e)
                    }
                }
            })
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.clear()
    }

    fun click(): Boolean {
        router.backTo(UsersListScreen.create())
        return false
    }
}