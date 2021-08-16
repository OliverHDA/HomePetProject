package ru.oliverhd.homepetproject.user

import moxy.viewstate.strategy.alias.SingleState
import ru.oliverhd.homepetproject.ScreenView
import ru.oliverhd.homepetproject.repository.GitHubRepository
import ru.oliverhd.homepetproject.repository.GithubUser

@SingleState
interface UserView : ScreenView {
    fun showRepositories(repositories: List<GitHubRepository>)
    fun showContent(githubUser: GithubUser)
}