package ru.oliverhd.homepetproject.userslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.terrakok.cicerone.Router
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.oliverhd.homepetproject.BackButtonListener
import ru.oliverhd.homepetproject.app.App
import ru.oliverhd.homepetproject.databinding.FragmentUsersBinding
import ru.oliverhd.homepetproject.repository.GithubUsersRepository
import javax.inject.Inject

class UsersListFragment : MvpAppCompatFragment(), UsersListView, BackButtonListener {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var githubUsersRepository: GithubUsersRepository

    private val presenter: UsersListPresenter by moxyPresenter {
        UsersListPresenter(
            usersRepository = githubUsersRepository,
            router = router
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

    override fun error(error: Throwable) {
        Toast.makeText(context, error.message, Toast.LENGTH_LONG).show()
    }

    override fun back() = presenter.backClick()

    companion object {
        fun newInstance(): Fragment = UsersListFragment().apply {
            App.instance.applicationComponent.inject(this)
        }
    }
}