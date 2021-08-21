package ru.oliverhd.homepetproject.user

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import ru.oliverhd.homepetproject.RxRepo
import ru.oliverhd.homepetproject.githubrepository.RepositoryScreen
import ru.oliverhd.homepetproject.repository.GitHubRepository
import ru.oliverhd.homepetproject.repository.GithubUser
import ru.oliverhd.homepetproject.repository.GithubUsersRepository
import ru.oliverhd.homepetproject.userslist.UsersListScreen

class UserPresenter(
    private val userLogin: String,
    private val usersRepository: GithubUsersRepository,
    private val router: Router
) : MvpPresenter<UserView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        disposables.add(
            usersRepository
                .getUserByLogin(userLogin)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(
                    ::onUserSuccess,
                    viewState::error
                )
        )
    }

    private fun onUserSuccess(githubUser: GithubUser) {
        viewState.showContent(githubUser)
        disposables.add(
            usersRepository.getRepositories(githubUser.reposUrl)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(
                    viewState::showRepositories,
                    viewState::error
                )
        )
    }

    fun click(): Boolean {
        router.backTo(UsersListScreen.create())
        return false
    }

    fun openRepository(gitHubRepository: GitHubRepository) {
        router.navigateTo(RepositoryScreen().create())
        RxRepo.setRepo(gitHubRepository)
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.clear()
    }
}