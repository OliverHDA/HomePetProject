package ru.oliverhd.homepetproject.userslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.oliverhd.homepetproject.app.App.Navigation.router
import ru.oliverhd.homepetproject.databinding.FragmentUsersBinding
import ru.oliverhd.homepetproject.repository.GithubUsersRepo
import ru.oliverhd.homepetproject.BackButtonListener

class UsersListFragment : MvpAppCompatFragment(), UsersListView, BackButtonListener {
    companion object {
        fun newInstance(): Fragment = UsersListFragment()
    }

    private val presenter: UsersListPresenter by moxyPresenter {
        UsersListPresenter(
            GithubUsersRepo(),
            router
        )
    }
    private var adapter: UsersListRVAdapter? = null

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
        adapter = UsersListRVAdapter(presenter.usersListPresenter)
        vb?.rvUsers?.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun back() = presenter.backClick()
}