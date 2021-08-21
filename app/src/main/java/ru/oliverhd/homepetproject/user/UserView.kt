package ru.oliverhd.homepetproject.user

import moxy.viewstate.strategy.alias.AddToEndSingle
import ru.oliverhd.homepetproject.ScreenView
import ru.oliverhd.homepetproject.repository.GitHubRepository
import ru.oliverhd.homepetproject.repository.GithubUser

@AddToEndSingle
interface UserView : ScreenView {
    fun showRepositories(repositories: List<GitHubRepository>)
    fun showContent(githubUser: GithubUser)
}