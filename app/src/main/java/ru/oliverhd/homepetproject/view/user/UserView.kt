package ru.oliverhd.homepetproject.view.user

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserView:MvpView {
    fun showUserLogin(login: String)
}