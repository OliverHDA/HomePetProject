package ru.oliverhd.homepetproject.githubrepository

import moxy.viewstate.strategy.alias.SingleState
import ru.oliverhd.homepetproject.ScreenView
import ru.oliverhd.homepetproject.repository.GitHubRepository

@SingleState
interface RepositoryView : ScreenView {
    fun showContent(gitHubRepository: GitHubRepository)
}