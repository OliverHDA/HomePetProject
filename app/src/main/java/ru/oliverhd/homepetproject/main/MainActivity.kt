package ru.oliverhd.homepetproject.main

import android.os.Bundle
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.github.terrakok.cicerone.androidx.FragmentScreen
import moxy.ktx.moxyPresenter
import ru.oliverhd.homepetproject.BackButtonListener
import ru.oliverhd.homepetproject.R
import ru.oliverhd.homepetproject.databinding.ActivityMainBinding
import ru.oliverhd.homepetproject.di.UsersListScreenFragment
import javax.inject.Inject

class MainActivity : AbsActivity(), MainView {

    private val navigator = AppNavigator(this, R.id.container)

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var router: Router

    @UsersListScreenFragment
    @Inject
    lateinit var usersListScreen: FragmentScreen

    private val presenter by moxyPresenter { MainPresenter(router, usersListScreen) }

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is BackButtonListener && it.back()) {
                return
            }
        }
        presenter.back()
    }
}