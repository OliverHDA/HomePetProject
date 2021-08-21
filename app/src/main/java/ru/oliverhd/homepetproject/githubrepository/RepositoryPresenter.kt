package ru.oliverhd.homepetproject.githubrepository

import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import ru.oliverhd.homepetproject.repository.GitHubRepository

class RepositoryPresenter(
    private val gitHubRepository: GitHubRepository
    ) : MvpPresenter<RepositoryView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showContent(gitHubRepository)
    }

    override fun onDestroy() {
        disposables.clear()
        super.onDestroy()
    }
}