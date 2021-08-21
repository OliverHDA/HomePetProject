package ru.oliverhd.homepetproject.di

import android.content.Context
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import ru.oliverhd.homepetproject.app.App
import ru.oliverhd.homepetproject.di.modules.*
import ru.oliverhd.homepetproject.user.UserFragment
import ru.oliverhd.homepetproject.userslist.UsersListFragment
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ContributesAndroidInjectorModule::class,
        GitHubUsersModule::class,
        GitHubApiModule::class,
        GitHubStorageModule::class,
        ScreenModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<App> {

    fun inject(usersListFragment: UsersListFragment)
    fun inject(userFragment: UserFragment)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withContext(context: Context): Builder

        @BindsInstance
        fun withNavigatorHolder(navigatorHolder: NavigatorHolder): Builder

        @BindsInstance
        fun withRouter(router: Router): Builder

        fun build(): ApplicationComponent
    }
}