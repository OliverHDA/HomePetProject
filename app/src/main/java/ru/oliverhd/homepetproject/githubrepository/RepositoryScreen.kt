package ru.oliverhd.homepetproject.githubrepository

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.oliverhd.homepetproject.repository.GitHubRepository

class RepositoryScreen() {

    fun create(gitHubRepository: GitHubRepository) = FragmentScreen {
        RepositoryFragment.newInstance(gitHubRepository)
    }
}