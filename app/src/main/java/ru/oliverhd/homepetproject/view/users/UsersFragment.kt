package ru.oliverhd.homepetproject.view.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.oliverhd.homepetproject.app.App
import ru.oliverhd.homepetproject.cicerone.AndroidScreens
import ru.oliverhd.homepetproject.databinding.FragmentUsersBinding
import ru.oliverhd.homepetproject.presenter.UsersPresenter
import ru.oliverhd.homepetproject.repository.GithubUsersRepo
import ru.oliverhd.homepetproject.view.BackButtonListener

class UsersFragment : MvpAppCompatFragment(), UsersView, BackButtonListener {
    companion object {
        fun newInstance() = UsersFragment()
    }

    private val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(
            GithubUsersRepo(),
            App.instance.router,
            AndroidScreens()
        )
    }
    private var adapter: UsersRVAdapter? = null

    private var vb: FragmentUsersBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        FragmentUsersBinding.inflate(inflater, container, false).also {
            vb = it
        }.root

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun init() {
        vb?.rvUsers?.layoutManager = LinearLayoutManager(context)
        adapter = UsersRVAdapter(presenter.usersListPresenter)
        vb?.rvUsers?.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backClick()
}