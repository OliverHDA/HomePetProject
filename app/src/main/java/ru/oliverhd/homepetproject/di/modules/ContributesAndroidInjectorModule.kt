package ru.oliverhd.homepetproject.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.oliverhd.homepetproject.main.MainActivity
import ru.oliverhd.homepetproject.user.UserFragment
import ru.oliverhd.homepetproject.userslist.UsersListFragment

@Module
interface ContributesAndroidInjectorModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun bindUsersListFragment(): UsersListFragment

    @ContributesAndroidInjector
    fun bindUserFragment(): UserFragment
}