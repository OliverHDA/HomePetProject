package ru.oliverhd.homepetproject.view.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.oliverhd.homepetproject.app.App
import ru.oliverhd.homepetproject.cicerone.AndroidScreens
import ru.oliverhd.homepetproject.databinding.FragmentUserBinding
import ru.oliverhd.homepetproject.presenter.UserPresenter
import ru.oliverhd.homepetproject.presenter.UsersPresenter
import ru.oliverhd.homepetproject.repository.GithubUsersRepo
import ru.oliverhd.homepetproject.view.BackButtonListener
import ru.oliverhd.homepetproject.view.users.UsersView

private const val ARG_USER_LOGIN = "userLogin"

class UserFragment : MvpAppCompatFragment(), UserView, BackButtonListener {

    private var userLogin: String? = null

    private val presenter by moxyPresenter {
        UserPresenter(
            GithubUsersRepo(),
            App.instance.router,
            AndroidScreens()
        )
    }

    private var binding: FragmentUserBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userLogin = it.getString(ARG_USER_LOGIN)
        }
        userLogin?.let { presenter.setUserLogin(it) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        fun newInstance(userLogin: String) =
            UserFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_USER_LOGIN, userLogin)
                }
            }
    }

    override fun showUserLogin(login: String) {
        binding?.UserLoginTextView?.text = login
    }

    override fun backPressed(): Boolean {
        return presenter.backClick()
    }
}