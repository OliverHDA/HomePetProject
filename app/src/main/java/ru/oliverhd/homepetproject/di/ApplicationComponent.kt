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
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ContributesAndroidInjectorModule::class,
        GitHubUsersModule::class,
        GitHubApiModule::class,
        GitHubStorageModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<App> {

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