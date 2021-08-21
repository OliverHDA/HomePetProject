package ru.oliverhd.homepetproject.githubrepository

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.oliverhd.homepetproject.databinding.FragmentRepositoryBinding
import ru.oliverhd.homepetproject.repository.GitHubRepository

private const val ARG_REPOSITORY = "repository"

class RepositoryFragment : MvpAppCompatFragment(), RepositoryView {

    private val gitHubRepository: GitHubRepository by lazy {
        arguments?.getParcelable<GitHubRepository>(ARG_REPOSITORY) as GitHubRepository
    }

    private val presenter by moxyPresenter {
        RepositoryPresenter(
            gitHubRepository
        )
    }

    private var binding: FragmentRepositoryBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRepositoryBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun showContent(gitHubRepository: GitHubRepository) {
        val repoName = "${gitHubRepository.owner.login}/${gitHubRepository.name}"
        val starsCount = "Star | ${gitHubRepository.stargazersCount}"
        val forksCount = "Fork | ${gitHubRepository.forksCount}"
        binding?.repositoryNameTextView?.text = repoName
        binding?.forkTextView?.text = forksCount
        binding?.starTextView?.text = starsCount
        binding?.descriptionTextView?.text = gitHubRepository.description
    }

    override fun error(error: Throwable) {
        Toast.makeText(context, error.message, Toast.LENGTH_LONG).show()
    }

    companion object {
        fun newInstance(gitHubRepository: GitHubRepository): Fragment =
            RepositoryFragment().apply {
                arguments = bundleOf(ARG_REPOSITORY to gitHubRepository)
            }
    }
}