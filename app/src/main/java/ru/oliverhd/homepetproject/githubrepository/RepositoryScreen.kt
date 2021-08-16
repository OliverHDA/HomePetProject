package ru.oliverhd.homepetproject.githubrepository

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.oliverhd.homepetproject.repository.GitHubRepository

class RepositoryScreen(private val gitHubRepository: GitHubRepository) {

    fun create() = FragmentScreen {
        RepositoryFragment.newInstance(gitHubRepository)
    }
}