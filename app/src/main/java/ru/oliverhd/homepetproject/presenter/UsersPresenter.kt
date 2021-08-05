package ru.oliverhd.homepetproject.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.oliverhd.homepetproject.cicerone.IScreens
import ru.oliverhd.homepetproject.model.GithubUser
import ru.oliverhd.homepetproject.repository.GithubUsersRepo
import ru.oliverhd.homepetproject.view.IUserListPresenter
import ru.oliverhd.homepetproject.view.users.UsersView
import ru.oliverhd.homepetproject.view.UserItemView

class UsersPresenter(private val usersRepo: GithubUsersRepo, private val router: Router, val screens: IScreens) :
    MvpPresenter<UsersView>() {

    class UsersListPresenter : IUserListPresenter {
        val users = mutableListOf<GithubUser>()
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
            router.navigateTo(screens.user(itemView.getLogin()), true)
        }
    }

    private fun loadData() {
        val users = usersRepo.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }
}