package ru.oliverhd.homepetproject.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.oliverhd.homepetproject.BackButtonListener
import ru.oliverhd.homepetproject.app.App.Navigation.router
import ru.oliverhd.homepetproject.databinding.FragmentUserBinding
import ru.oliverhd.homepetproject.repository.GithubUsersRepo

private const val ARG_USER_LOGIN = "userLogin"

class UserFragment : MvpAppCompatFragment(), UserView, BackButtonListener {

    private val userLogin: String by lazy {
        arguments?.getString(ARG_USER_LOGIN).orEmpty()
    }

    private val presenter by moxyPresenter {
        UserPresenter(
            userLogin,
            GithubUsersRepo(),
            router
        )
    }

    private var binding: FragmentUserBinding? = null

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

    override fun showUserLogin(login: String) {
        binding?.UserLoginTextView?.text = login
    }

    override fun back(): Boolean {
        return presenter.click()
    }

    companion object {
        fun newInstance(userLogin: String): Fragment =
            UserFragment().apply {
                arguments = bundleOf(ARG_USER_LOGIN to userLogin)
            }
    }
}