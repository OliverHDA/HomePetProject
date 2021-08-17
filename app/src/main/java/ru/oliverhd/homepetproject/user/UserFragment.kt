package ru.oliverhd.homepetproject.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.oliverhd.homepetproject.BackButtonListener
import ru.oliverhd.homepetproject.app.App.Navigation.router
import ru.oliverhd.homepetproject.databinding.FragmentUserBinding
import ru.oliverhd.homepetproject.repository.GitHubRepository
import ru.oliverhd.homepetproject.repository.GithubUser
import ru.oliverhd.homepetproject.repository.GithubUsersRepositoryFactory

private const val ARG_USER_LOGIN = "userLogin"

class UserFragment : MvpAppCompatFragment(), UserView, BackButtonListener,
    RepositoriesAdapter.Delegate {

    private val userLogin: String by lazy {
        arguments?.getString(ARG_USER_LOGIN).orEmpty()
    }

    @Suppress("unused")
    private val presenter by moxyPresenter {
        UserPresenter(
            userLogin = userLogin,
            usersRepository = GithubUsersRepositoryFactory.create(requireContext()),
            router = router
        )
    }

    private var binding: FragmentUserBinding? = null
    private val repositoriesAdapter = RepositoriesAdapter(delegate = this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.repositoriesRecycler?.adapter = repositoriesAdapter
    }

    override fun showContent(githubUser: GithubUser) {
        binding?.userLoginTextView?.text = githubUser.login
        binding?.avatarImageView?.let { avatarImageView ->
            context?.let { context ->
                Glide
                    .with(context)
                    .load(githubUser.avatarUrl)
                    .circleCrop()
                    .into(avatarImageView)
            }
        }

    }

    override fun error(error: Throwable) {
        Toast.makeText(context, error.message, Toast.LENGTH_LONG).show()
    }

    override fun back(): Boolean {
        return presenter.click()
    }

    override fun showRepositories(repositories: List<GitHubRepository>) {
        repositoriesAdapter.submitList(repositories)
        binding?.repositoriesRecycler?.layoutManager = LinearLayoutManager(context)
    }

    override fun onRepositoryClicked(repository: GitHubRepository) {
        presenter.openRepository(repository)
    }

    companion object {
        fun newInstance(userLogin: String): Fragment =
            UserFragment().apply {
                arguments = bundleOf(ARG_USER_LOGIN to userLogin)
            }
    }
}