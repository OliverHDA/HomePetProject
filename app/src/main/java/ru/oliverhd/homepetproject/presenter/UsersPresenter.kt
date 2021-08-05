package ru.oliverhd.homepetproject.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.oliverhd.homepetproject.model.GithubUser
import ru.oliverhd.homepetproject.repository.GithubUsersRepo
import ru.oliverhd.homepetproject.view.IUserListPresenter
import ru.oliverhd.homepetproject.view.UsersView
import ru.oliverhd.homepetproject.view.UserItemView

class UsersPresenter(private val usersRepo: GithubUsersRepo, private val router: Router) :
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
            //TODO: переход на экран пользователя
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