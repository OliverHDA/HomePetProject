package ru.oliverhd.homepetproject.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.oliverhd.homepetproject.main.MainActivity
import ru.oliverhd.homepetproject.main.MainPresenter
import ru.oliverhd.homepetproject.user.UserFragment
import ru.oliverhd.homepetproject.user.UserPresenter
import ru.oliverhd.homepetproject.userslist.UsersListFragment
import ru.oliverhd.homepetproject.userslist.UsersListPresenter

@Module
interface ContributesAndroidInjectorModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun bindUsersListFragment(): UsersListFragment

    @ContributesAndroidInjector
    fun bindUserFragment(): UserFragment
}