package ru.oliverhd.homepetproject.githubrepository

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.oliverhd.homepetproject.repository.GitHubRepository
import ru.oliverhd.homepetproject.user.UserScreen

class RepositoryPresenter(
    private val gitHubRepository: GitHubRepository?,
    private val router: Router
) :
    MvpPresenter<RepositoryView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        gitHubRepository?.let(viewState::showContent)

    }

    fun back(): Boolean {
        router.backTo(gitHubRepository?.owner?.login?.let { UserScreen(it).create() })
        return false
    }
}