package ru.oliverhd.homepetproject.di.modules

import com.github.terrakok.cicerone.androidx.FragmentScreen
import dagger.Module
import dagger.Provides
import ru.oliverhd.homepetproject.di.UsersListScreenFragment
import ru.oliverhd.homepetproject.userslist.UsersListFragment

@Module
class ScreenModule {

    @UsersListScreenFragment
    @Provides
    fun provideUsersListScreen(): FragmentScreen =
        FragmentScreen { UsersListFragment.newInstance() }
}
