package ru.oliverhd.homepetproject.main

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.oliverhd.homepetproject.R
import ru.oliverhd.homepetproject.app.App.Navigation.navigatorHolder
import ru.oliverhd.homepetproject.app.App.Navigation.router
import ru.oliverhd.homepetproject.databinding.ActivityMainBinding
import ru.oliverhd.homepetproject.BackButtonListener

class MainActivity : MvpAppCompatActivity(), MainView {

    private val navigator = AppNavigator(this, R.id.container)

    private val presenter by moxyPresenter { MainPresenter(router) }
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