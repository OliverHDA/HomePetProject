package ru.oliverhd.homepetproject.githubrepository

import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import ru.oliverhd.homepetproject.RxRepo

class RepositoryPresenter(
) :
    MvpPresenter<RepositoryView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        disposables.add(
            RxRepo.getRxRepo()
                .subscribe(viewState::showContent, viewState::error)
        )
    }

    override fun onDestroy() {
        disposables.clear()
        super.onDestroy()
    }
}