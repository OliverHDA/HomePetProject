package ru.oliverhd.homepetproject.userslist

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpPresenter
import ru.oliverhd.homepetproject.UserItemView
import ru.oliverhd.homepetproject.repository.GithubUsersRepository
import ru.oliverhd.homepetproject.user.UserScreen
import ru.oliverhd.homepetproject.userslist.GithubUserViewModel.Mapper

class UsersListPresenter(
    private val usersRepository: GithubUsersRepository,
    private val router: Router
) :
    MvpPresenter<UsersListView>() {

    private val disposables = CompositeDisposable()

    class UsersListPresenter : UserListPresenter {
        val users = mutableListOf<GithubUserViewModel>()
        override var itemClickListener: ((UserItemView) -> Unit)? = null

        override fun getCount() = users.size

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        usersListPresenter.itemClickListener = { itemView ->
            router.navigateTo(UserScreen(itemView.getLogin()).create(), true)
        }
    }

    private fun loadData() {
        usersRepository
            .getUsers()
            .map { users -> users.map(Mapper::map) }
            .subscribe(object : SingleObserver<List<GithubUserViewModel>> {
                override fun onSubscribe(d: Disposable?) {
                    disposables.add(d)
                }

                override fun onSuccess(t: List<GithubUserViewModel>?) {
                    t?.let { usersListPresenter.users.addAll(it) }
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

    fun backClick(): Boolean {
        router.exit()
        return true
    }
}